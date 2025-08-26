package com.xh.system.application.service;

import com.xh.common.core.web.MyException;
import com.xh.common.core.web.RestResponse;
import com.xh.system.api.request.SwitchUserRoleRequest;
import com.xh.system.api.response.SwitchUserRoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 12:54
 */
@Service
public class SysLoginService {
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

    public void switchLocale(Map<String, Object> params) {

    }

    public RestResponse<?> logout() {
        return null;
    }
}
