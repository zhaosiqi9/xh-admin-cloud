package com.xh.system.application.service;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.exception.MyException;
import com.xh.common.base.web.PageResult;
import com.xh.jwt.constant.JwtConstant;
import com.xh.jwt.dto.OnlineUserDTO;
import com.xh.jwt.dto.SysLoginUserInfoDTO;
import com.xh.jwt.dto.SysOrgRoleDTO;
import com.xh.jwt.util.JwtUtil;
import com.xh.system.api.request.SwitchUserRoleRequest;
import com.xh.system.api.request.SystemUserQueryRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.SwitchUserRoleResponse;
import com.xh.system.api.response.SystemUserQueryResponse;
import com.xh.system.application.command.sysuser.GetUserInfoCommand;
import com.xh.system.application.command.sysuser.UpdateUserInfoCommand;
import com.xh.system.application.mapstract.SysUserEntity2ResponseMapper;
import com.xh.system.application.service.dto.LoginUserInfoVO;
import com.xh.system.application.service.sub.ThirdPartyService;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public SysUserPO personalCenterSave(SysUserPO sysUserPO) {
        return null;
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
//         try {
//            SaSession session = StpUtil.getSession();
//            SaSession tokenSession = StpUtil.getTokenSession();
//            LoginUserInfoVO loginUserInfo = null;
//            if (session != null && tokenSession != null) {
//                SysLoginUserInfoDTO loginUserInfoDTO = session.getModel(JwtConstant.SYS_USER_KEY, SysLoginUserInfoDTO.class);
//                loginUserInfo = new LoginUserInfoVO();
//                loginUserInfo.setTokenName(StpUtil.getTokenName());
//                loginUserInfo.setTokenValue(StpUtil.getTokenValue());
//                loginUserInfo.setUser(loginUserInfoDTO.getUser());
//                OnlineUserDTO onlineUser = tokenSession.getModel(JwtConstant.SYS_USER_KEY, OnlineUserDTO.class);
//                List<SysOrgRoleDTO> roles = loginUserInfoDTO.getRoles();
//                for (SysOrgRoleDTO role : roles) {
//                    role.setActive(Objects.equals(onlineUser.getRoleId(), role.getSysRoleId()) && Objects.equals(onlineUser.getOrgId(), role.getSysOrgId()));
//                }
//                loginUserInfo.setRoles(roles);
//                loginUserInfo.setMenus(getRolePermissions(onlineUser.getRoleId(), refresh));
//            }
//            return loginUserInfo;
//        } catch (NotLoginException e) {
//            return null;
//        }
        return null;
    }


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
}
