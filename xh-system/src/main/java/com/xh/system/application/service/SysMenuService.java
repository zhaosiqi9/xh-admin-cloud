package com.xh.system.application.service;

import com.xh.system.api.response.UserPermissionResponse;
import com.xh.system.application.mapstract.SysMenuEntity2ResponseMapper;
import com.xh.system.domain.aggregate.SysMenuAggregate;
import com.xh.system.domain.service.SysMenuDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

    public List<UserPermissionResponse> rolePermissionList(Long roleId) {
        if (roleId == null) {
            return List.of();
        }
        SysMenuAggregate root = sysMenuDomainService.rolePermissionList(roleId);
        return SysMenuEntity2ResponseMapper.INSTANCE.toUserPermissionResponse(root);
    }
}
