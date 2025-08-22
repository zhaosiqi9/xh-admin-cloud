package com.xh.system.domain.repository.sysuser.impl;

import com.xh.system.domain.constant.SysUserConstant;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import com.xh.system.infrastructure.mysql.service.SysUserRecordService;
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
    private SysUserRecordService sysUserRecordService;

    @Override
    protected SysUserConstant getType() {
        return SysUserConstant.DEFAULT;
    }
    

}
