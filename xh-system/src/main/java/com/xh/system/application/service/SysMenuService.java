package com.xh.system.application.service;

import com.xh.common.core.constants.SystemRedisConstant;
import com.xh.jwt.dto.RolePermissionsDTO;
import com.xh.redis.service.RedisService;
import com.xh.system.api.request.user.UserPermissionRequest;
import com.xh.system.api.response.UserPermissionResponse;
import com.xh.system.application.mapstract.SysMenuEntity2ResponseMapper;
import com.xh.system.domain.aggregate.SysMenuAggregate;
import com.xh.system.domain.service.SysMenuDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:12
 */
@Service
public class SysMenuService {

    @Resource
    private SysMenuDomainService sysMenuDomainService;

    @Resource
    private RedisService redisService;

    public List<UserPermissionResponse> rolePermissionList(UserPermissionRequest request) {
        if (request == null || request.getRoleId() == null) {
            return List.of();
        }
        if (!request.isRefresh()) {
            RolePermissionsDTO rolePermissions = redisService.getCacheObject(SystemRedisConstant.ROLE_PERMISSIONS_PREFIX.getValue() + request.getRoleId());
            if (rolePermissions != null) {
                return SysMenuEntity2ResponseMapper.INSTANCE.rolePermission2UserPermissionResponse(rolePermissions.getPermissions());
            }
        }
        SysMenuAggregate root = sysMenuDomainService.rolePermissionList(request.getRoleId());

        RolePermissionsDTO rolePermissions = new RolePermissionsDTO();
        rolePermissions.setRoleId(request.getRoleId());
        rolePermissions.setCreateTime(LocalDateTime.now());

        redisService.setCacheObject(SystemRedisConstant.ROLE_PERMISSIONS_PREFIX.getValue() + request.getRoleId(), rolePermissions);

        return SysMenuEntity2ResponseMapper.INSTANCE.toUserPermissionResponse(root);
    }
}
