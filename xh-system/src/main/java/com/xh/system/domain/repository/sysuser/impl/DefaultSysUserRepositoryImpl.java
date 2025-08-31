package com.xh.system.domain.repository.sysuser.impl;

import com.xh.common.base.constant.SysUserConstant;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import com.xh.system.infrastructure.mysql.service.SysUserPOService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 17:51
 */
@Service
public class DefaultSysUserRepositoryImpl extends AbstractSysUserRepository {

    @Resource
    private SysUserPOService sysUserPOService;

    @Override
    protected SysUserConstant.SysUserRootType getType() {
        return SysUserConstant.SysUserRootType.DEFAULT;
    }


}
