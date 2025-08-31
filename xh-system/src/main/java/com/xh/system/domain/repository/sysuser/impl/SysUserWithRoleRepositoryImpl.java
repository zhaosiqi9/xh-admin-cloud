package com.xh.system.domain.repository.sysuser.impl;

import com.xh.common.base.constant.SysUserConstant;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 10:16
 */
@Service
public class SysUserWithRoleRepositoryImpl extends AbstractSysUserRepository {

    @Override
    protected SysUserConstant.SysUserRootType getType() {
        return SysUserConstant.SysUserRootType.ROLE;
    }

    @Override
    public SysUserAggregate findByRootId(Long rootId) {
        if (rootId == null) {
            return null;
        }
        SysUserAggregate root = new SysUserAggregate();
        SysUser sysUser = findMainByRootId(rootId);
        if (sysUser == null) {
            return null;
        }
        root.setSysUser(sysUser);
        root.setRootId(rootId);
        return root;
    }


}
