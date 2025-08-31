package com.xh.system.interfaces;

import com.xh.common.core.api.contract.RemotePermissionContract;
import com.xh.system.application.service.PermissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/31 20:28
 */
@Tag(name = "权限管理")
@RestController
@RequestMapping("/api/system/permission")
public class PermissionController implements RemotePermissionContract {

    @Resource
    private PermissionService permissionService;
    
    @Override
    public List<String> getPermissionList(Long loginId, String loginType) {
        if (loginId == null) {
            return List.of();
        }
        return permissionService.getMenuPermission(loginId, loginType);
    }

    @Override
    public List<String> getRoleList(Long loginId, String loginType) {
        if (loginId == null) {
            return List.of();
        }
        return permissionService.getRoleList(loginId, loginType);
    }
}
