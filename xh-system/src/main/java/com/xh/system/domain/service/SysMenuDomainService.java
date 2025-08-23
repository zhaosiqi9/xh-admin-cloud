package com.xh.system.domain.service;

import com.xh.system.domain.aggregate.SysMenuAggregate;
import com.xh.system.domain.constant.sysmenu.SysMenuConstant;
import com.xh.system.domain.repository.sysmenu.AbstractSysMenuRepository;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:12
 */
@Service
public class SysMenuDomainService {
    
    public static AbstractSysMenuRepository getRepository(SysMenuConstant.SysMenuRootType type) {
        return AbstractSysMenuRepository.getRepository(type);
    }

    public SysMenuAggregate rolePermissionList(Long roleId) {
        if (roleId == null) {
            return null;
        }
        return getRepository(SysMenuConstant.SysMenuRootType.DEFAULT).findByRootId(roleId);
    }
}
