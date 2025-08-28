package com.xh.system.application.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.core.web.PageResult;
import com.xh.system.api.request.SwitchUserRoleRequest;
import com.xh.system.api.request.SystemUserQueryRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.SwitchUserRoleResponse;
import com.xh.system.api.response.SystemUserQueryResponse;
import com.xh.system.application.command.sysuser.GetUserInfoCommand;
import com.xh.system.application.command.sysuser.UpdateUserInfoCommand;
import com.xh.system.application.mapstract.SysUserEntity2ResponseMapper;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.sysuser.SysUserConstant;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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

    public SysUserPO personalCenterSave(SysUserPO sysUserPO) {
        return null;
    }

    public SysUserPO getById(Serializable loginId) {
        return null;
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
//        SysLoginUserInfoDTO loginUserInfoDTO = LoginUtil.getSysUserInfo();
//        List<SysOrgRoleDTO> roles = loginUserInfoDTO.getRoles();
//        for (SysOrgRoleDTO orgRole : roles) {
//            //从当前登录用户session中寻找匹配的角色，并设置当前角色，机构，及名称
//            if (Objects.equals(orgRole.getSysOrgId().toString(), orgId) && Objects.equals(orgRole.getSysRoleId().toString(), roleId)) {
//                SaSession tokenSession = StpUtil.getTokenSession();
//                OnlineUserDTO onlineUserDTO = tokenSession.getModel(LoginUtil.SYS_USER_KEY, OnlineUserDTO.class);
//                onlineUserDTO.setOrgId(orgRole.getSysOrgId());
//                onlineUserDTO.setOrgName(orgRole.getOrgName());
//                onlineUserDTO.setRoleId(orgRole.getSysRoleId());
//                onlineUserDTO.setRoleName(orgRole.getRoleName());
//                tokenSession.set(LoginUtil.SYS_USER_KEY, onlineUserDTO);
//                return getCurrentLoginUserVO(true);
//            }
//        }
//        throw new MyException("角色切换异常，请重新登录后操作！");
        return null;
    }


    public PageResult<SystemUserQueryResponse> query(SystemUserQueryRequest request) {
        Page<SysUserPO> userPage = sysUserDomainService.getRepository(SysUserConstant.SysUserRootType.DEFAULT).query(request.getParam().getName(),
                request.getParam().getCode(),
                request.getCurrentPage(), request.getPageSize());
        return SysUserEntity2ResponseMapper.INSTANCE.toSystemUserQueryResponseList(userPage);
    }

}
