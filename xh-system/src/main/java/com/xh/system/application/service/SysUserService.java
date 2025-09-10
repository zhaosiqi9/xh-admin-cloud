package com.xh.system.application.service;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.common.base.constant.SysUserGroupConstant;
import com.xh.common.base.exception.MyException;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.core.utils.AssertUtil;
import com.xh.common.jwt.constant.JwtConstant;
import com.xh.common.jwt.dto.OnlineUserDTO;
import com.xh.common.jwt.dto.SysLoginUserInfoDTO;
import com.xh.common.jwt.dto.SysOrgRoleDTO;
import com.xh.common.jwt.dto.SysUserDTO;
import com.xh.common.jwt.util.JwtUtil;
import com.xh.system.api.request.SwitchUserRoleRequest;
import com.xh.system.api.request.SystemUserQueryRequest;
import com.xh.system.api.request.user.UserQeryOnlineUserRequest;
import com.xh.system.api.request.user.UserQueryUserGroupListRequest;
import com.xh.system.api.request.user.UserSaveUserJobsRequest;
import com.xh.system.api.request.user.UserSwitchMenuPropRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.SwitchUserRoleResponse;
import com.xh.system.api.response.SystemUserQueryResponse;
import com.xh.system.application.command.sysuser.GetUserInfoCommand;
import com.xh.system.application.command.sysuser.UpdateUserInfoCommand;
import com.xh.system.application.mapstract.SysUserEntity2ResponseMapper;
import com.xh.system.application.service.dto.LoginUserInfoVO;
import com.xh.system.application.service.sub.ThirdPartyService;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserGroup;
import com.xh.system.domain.entity.SysUserJob;
import com.xh.system.domain.service.SysMenuDomainService;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.domain.service.SysUserGroupDomainService;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 12:48
 */
@Service
@Slf4j
public class SysUserService {
    @Resource
    private SysUserDomainService sysUserDomainService;

    @Resource
    private ThirdPartyService thirdPartyService;

    @Resource
    private SysMenuDomainService sysMenuDomainService;

    @Resource
    private SysUserGroupDomainService sysUserGroupDomainService;
    @Autowired
    private PermissionService permissionService;

    public SysUser personalCenterSave(SysUser sysUser) {

        AssertUtil.equals(sysUser.getId(), StpUtil.getLoginId(), "非法请求！");
        SysUserAggregate root =
                Optional.ofNullable(sysUserDomainService.getRoot(sysUser.getId(), SysUserConstant.SysUserRootType.DEFAULT)).orElseThrow(() -> new MyException("用户不存在"));
        SysUser sysUser1 = Optional.ofNullable(root.getSysUser()).orElseThrow(() -> new MyException("用户不存在"));
        sysUser1.setName(sysUser.getName());
        sysUser1.setPassword(sysUser.getPassword());
        sysUser1.setAvatar(sysUser.getAvatar());
        sysUser1.setTelephone(sysUser.getTelephone());
        save(sysUser1);

        //刷新一下
        SaSession session = StpUtil.getSession();
        SysLoginUserInfoDTO userInfoDTO = session.getModel(JwtConstant.SYS_USER_KEY, SysLoginUserInfoDTO.class);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser1, sysUserDTO);
        userInfoDTO.setUser(sysUserDTO);
        session.set(JwtConstant.SYS_USER_KEY, userInfoDTO);
        return sysUser1;
    }

    public SysUser getById(Long userId) {
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(userId, SysUserConstant.SysUserRootType.DEFAULT)).orElse(new SysUserAggregate());
        return root.getSysUser();
    }

    public GetUserInfoResponse getUserInfo(GetUserInfoCommand command) {
        SysUserAggregate root =
                Optional.ofNullable(sysUserDomainService.getRootByLoginAccount(command.getUserName(), command.isEnabled(), command.getType())).orElseThrow(() -> new RuntimeException("用户不存在"));
        log.info("root:{}", JSON.toJSONString(root));
        return SysUserEntity2ResponseMapper.INSTANCE.toGetUserInfoResponse(root);
    }

    public boolean clearFailuresNum(UpdateUserInfoCommand command) {
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(command.getId(), command.getType())).orElseThrow(() -> new RuntimeException("用户不存在"));
        sysUserDomainService.clearFailuresNum(root, command.getId(), command.getType());
        return true;
    }

    public boolean loginFailUpdateInfo(UpdateUserInfoCommand command) {
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(command.getId(), command.getType())).orElseThrow(() -> new RuntimeException("用户不存在"));
        sysUserDomainService.loginFailUpdateInfo(root,
                command.getId(),
                command.getFailuresNum(),
                command.getStatus(),
                command.getLockMsg(),
                command.getType());
        return true;
    }

    public SwitchUserRoleResponse switchUserRole(SwitchUserRoleRequest request) {
        Long orgId = request.getSysOrgId();
        Long roleId = request.getSysRoleId();
        SysLoginUserInfoDTO loginUserInfoDTO = JwtUtil.getSysUserInfo();
        List<SysOrgRoleDTO> roles = Optional.ofNullable(loginUserInfoDTO).orElse(new SysLoginUserInfoDTO()).getRoles();
        for (SysOrgRoleDTO orgRole : roles) {
            //从当前登录用户session中寻找匹配的角色，并设置当前角色，机构，及名称
            if (Objects.equals(orgRole.getSysOrgId(), orgId) && Objects.equals(orgRole.getSysRoleId(), roleId)) {
                SaSession tokenSession = StpUtil.getTokenSession();
                OnlineUserDTO onlineUserDTO = tokenSession.getModel(JwtConstant.SYS_USER_KEY, OnlineUserDTO.class);
                onlineUserDTO.setOrgId(orgRole.getSysOrgId());
                onlineUserDTO.setOrgName(orgRole.getOrgName());
                onlineUserDTO.setRoleId(orgRole.getSysRoleId());
                onlineUserDTO.setRoleName(orgRole.getRoleName());
                tokenSession.set(JwtConstant.SYS_USER_KEY, onlineUserDTO);
//                return getCurrentLoginUserVO(true);
                return null;
            }
        }
        throw new MyException("角色切换异常，请重新登录后操作！");
    }

    /**
     * 获取当前token的用户角色信息
     *
     * @param refresh 是否刷新缓存
     */
    private LoginUserInfoVO getCurrentLoginUserVO(boolean refresh) {
try {
            SaSession session = StpUtil.getSession();
            SaSession tokenSession = StpUtil.getTokenSession();
            LoginUserInfoVO loginUserInfo = null;
            if (session != null && tokenSession != null) {
                SysLoginUserInfoDTO loginUserInfoDTO = session.getModel(JwtConstant.SYS_USER_KEY, SysLoginUserInfoDTO.class);
                loginUserInfo = new LoginUserInfoVO();
                loginUserInfo.setTokenName(StpUtil.getTokenName());
                loginUserInfo.setTokenValue(StpUtil.getTokenValue());
                loginUserInfo.setUser(loginUserInfoDTO.getUser());
                OnlineUserDTO onlineUser = tokenSession.getModel(JwtConstant.SYS_USER_KEY, OnlineUserDTO.class);
                List<SysOrgRoleDTO> roles = loginUserInfoDTO.getRoles();
                for (SysOrgRoleDTO role : roles) {
                    role.setActive(Objects.equals(onlineUser.getRoleId(), role.getSysRoleId()) && Objects.equals(onlineUser.getOrgId(), role.getSysOrgId()));
                }
                loginUserInfo.setRoles(roles);
                //todo 获取菜单权限
//                loginUserInfo.setMenus(permissionService.getMenuPermission(onlineUser.getRoleId(), refresh));
            }
            return loginUserInfo;
        } catch (NotLoginException e) {
            return null;
        }    }


    public PageResult<SystemUserQueryResponse> query(SystemUserQueryRequest request) {
        Page<SysUserPO> userPage = SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.DEFAULT).query(request.getParam().getName(),
                request.getParam().getCode(),
                request.getCurrentPage(), request.getPageSize());
        return SysUserEntity2ResponseMapper.INSTANCE.toSystemUserQueryResponseList(userPage);
    }

    public SysUser save(SysUser sysUser) {
        return sysUserDomainService.saveSysUser(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean delUserByIds(List<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }
        return sysUserDomainService.delUserByIds(ids);
    }

    public void export(SystemUserQueryRequest request) {
        PageResult<SystemUserQueryResponse> userPage = query(request);
        //todo 导出
    }

    public void switchMenuProp(UserSwitchMenuPropRequest param) {
        SysUserAggregate root =
                Optional.ofNullable(sysUserDomainService.getRoot(param.getId(), SysUserConstant.SysUserRootType.DEFAULT)).orElseThrow(() -> new MyException("用户不存在"));
        SysUser menu = Optional.ofNullable(root.getSysUser()).orElseThrow(() -> new MyException("用户不存在"));
        if ("enabled".equals(param.getProp())) menu.setEnabled(param.isValue());
        else throw new MyException("参数异常，检查后重试！");
        sysUserDomainService.saveSysUser(menu);
    }

    public ArrayList<Map<String, Object>> imports(List<SysUser> sysUsers) {
        return null;
    }


    public void resetPassword(SysUser sysUsers) {
        SysUserAggregate root =
                Optional.ofNullable(sysUserDomainService.getRoot(sysUsers.getId(), SysUserConstant.SysUserRootType.DEFAULT)).orElseThrow(() -> new MyException("用户不存在"));
        SysUser user = Optional.ofNullable(root.getSysUser()).orElseThrow(() -> new MyException("用户不存在"));
        sysUserDomainService.resetPassword(root, user.getId(), sysUsers.getPassword());
    }

    public PageResult<SysUserGroup> queryUserGroupList(PageQuery<UserQueryUserGroupListRequest> pageQuery) {
        String code = Optional.ofNullable(pageQuery.getParam().getCode()).orElseThrow(() -> new MyException("参数异常，检查后重试！"));
        String name = Optional.ofNullable(pageQuery.getParam().getName()).orElseThrow(() -> new MyException("参数异常，检查后重试！"));

        Page<SysUserGroup> page =
                Optional.ofNullable(SysUserGroupDomainService.getRepository(SysUserGroupConstant.UserGroupMemberRootType.DEFAULT).queryUserGroupPage(pageQuery.getCurrentPage(),
                        pageQuery.getPageSize(), code, name)).orElse(new Page<>());
        return SysUserEntity2ResponseMapper.INSTANCE.toSysUserGroupPageResult(page);
    }

    public SysUserGroup saveUserGroup(SysUserGroup sysUserGroup) {
        List<SysUserGroup> groupList =
                Optional.ofNullable(SysUserGroupDomainService.getRepository(SysUserGroupConstant.UserGroupMemberRootType.DEFAULT).queryUserGroupSaveQuery(sysUserGroup)).orElse(List.of());
        if (CollUtil.isNotEmpty(groupList)) {
            throw new MyException("用户组%s已存在，不能新增重复的用户组！".formatted(sysUserGroup.getName()));
        }

        if (sysUserGroup.getId() == null) {
            sysUserGroupDomainService.saveUserGroup(sysUserGroup);
        } else {
            sysUserGroupDomainService.updateUserGroup(sysUserGroup);
        }
        return sysUserGroup;
    }

    public SysUserGroup getUserGroupById(Long id) {
        return Optional.ofNullable(SysUserGroupDomainService.getRepository(SysUserGroupConstant.UserGroupMemberRootType.DEFAULT).queryUserGroupById(id)).orElseThrow(() -> new MyException("用户组不存在"));
    }

    public boolean delUserGroup(List<Long> ids) {
        sysUserGroupDomainService.delUserGroup(ids, SysUserGroupConstant.UserGroupMemberRootType.MEMBER);
        return true;
    }

    public List<SysUserJob> getUserJobs(SysUserJob param) {
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(param.getUserId(), SysUserConstant.SysUserRootType.JOB)).orElseThrow(() -> new MyException("用户不存在"));
        List<SysUserJob> sysUserJobs = Optional.ofNullable(root.getSysUserJobList()).orElse(List.of());
        if (param.getType() != null) {
            sysUserJobs = sysUserJobs.stream().filter(job -> Objects.equals(job.getType(), param.getType())).toList();
        }
        return sysUserJobs;
    }

    public boolean saveUserJobs(UserSaveUserJobsRequest sysUserJobDTO) {
        Long userId = Optional.ofNullable(sysUserJobDTO.getUserId()).orElseThrow(() -> new MyException("参数异常，检查后重试！"));
        Integer type = Optional.ofNullable(sysUserJobDTO.getType()).orElseThrow(() -> new MyException("参数异常，检查后重试！"));
        AssertUtil.isNotEmpty(sysUserJobDTO.getJobData(), "参数异常，检查后重试！");
        List<SysUserJob> userJobList = SysUserEntity2ResponseMapper.INSTANCE.toSysUserJobList(sysUserJobDTO.getJobData());
        sysUserDomainService.saveUserJobs(userId, type, userJobList, SysUserConstant.SysUserRootType.JOB);
        return true;
    }

    public PageResult<OnlineUserDTO> queryOnlineUser(PageQuery<UserQeryOnlineUserRequest> pageQuery) {
         final UserQeryOnlineUserRequest param = pageQuery.getParam();
        // 查询所有已登录的 Token
        List<String> tokens = StpUtil.searchTokenValue("", 0, -1, false);
        List<OnlineUserDTO> onlineUserList = tokens.stream()
                //截取实际的token值，去掉前缀
                .map(i -> i.split(":")[3])
                //过滤掉未登录的token
                .filter(i -> StpUtil.getLoginIdByToken(i) != null)
                .map(StpUtil::getTokenSessionByToken)
                .map(i -> i.getModel(JwtConstant.SYS_USER_KEY, OnlineUserDTO.class))
                .filter(Objects::nonNull)
                //模糊查询
                .filter(i -> {
                    boolean r = true;
                    if (StrUtil.isNotEmpty(param.getUserCode())) {
                        r = i.getUserCode().contains(param.getUserCode());
                    }
                    if (r && StrUtil.isNotEmpty(param.getUserName())) {
                        r = i.getUserName().contains(param.getUserName());
                    }
                    if (r && StrUtil.isNotEmpty(param.getIp())) {
                        r = i.getLoginIp().contains(param.getIp());
                    }
                    return r;
                })
                //排序
                .sorted((a, b) -> {
                    if (pageQuery.getOrderProp() == null || pageQuery.getOrderDirection() == null) {
                        pageQuery.setOrderProp("loginTime");
                        pageQuery.setOrderDirection(PageQuery.OrderDirection.desc);
                    }
                    try {
                        Field field = FieldUtils.getField(OnlineUserDTO.class, pageQuery.getOrderProp());
                        if (field == null) return 0;
                        field.setAccessible(true);
                        Object aVal = field.get(a);
                        Object bVal = field.get(b);
                        if (aVal != null && bVal != null) {
                            var px = aVal.toString().compareTo(bVal.toString());
                            if (pageQuery.getOrderDirection() == PageQuery.OrderDirection.desc) {
                                return -px;
                            }
                            return px;
                        }
                    } catch (ReflectiveOperationException e) {
                        log.error("比较错误", e);
                        throw new MyException(e.getMessage());
                    }
                    return 0;
                })
                .toList();
        PageResult<OnlineUserDTO> pageResult = new PageResult<>();
        pageResult.setIsPage(pageQuery.getIsPage());
        pageResult.setCurrentPage(pageQuery.getCurrentPage());
        pageResult.setPageSize(pageQuery.getPageSize());
        pageResult.setTotal(onlineUserList.size());
        if (pageQuery.getIsPage()) {
            onlineUserList = onlineUserList.stream()
                    .skip((long) (pageQuery.getCurrentPage() - 1) * pageQuery.getPageSize())
                    .limit(pageQuery.getPageSize())
                    .toList();
        }
        pageResult.setList(onlineUserList);
        return pageResult;
    }

    public void kickOut(String token) {
        StpUtil.kickoutByTokenValue(token);
    }

    public void roleSort(String roleSorter) {
        Long userId = (Long) StpUtil.getLoginId();
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(userId, SysUserConstant.SysUserRootType.DEFAULT)).orElseThrow(() -> new MyException("用户不存在"));
        SysUser sysUser = root.getSysUser();
        sysUser.setRoleSorter(roleSorter);
        sysUserDomainService.roleSort(root, sysUser);

        // 刷新缓存
        SaSession session = StpUtil.getSession();
        SysLoginUserInfoDTO loginUserInfoDTO = session.getModel(JwtConstant.SYS_USER_KEY, SysLoginUserInfoDTO.class);
        loginUserInfoDTO.setRoles(SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.DEFAULT).getUserRoles(userId));
        session.set(JwtConstant.SYS_USER_KEY, loginUserInfoDTO);
    }

    public List<SysUserGroup> getUserGroups(Long userId) {
        return SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.DEFAULT).getUserGroups(userId);
    }
}
