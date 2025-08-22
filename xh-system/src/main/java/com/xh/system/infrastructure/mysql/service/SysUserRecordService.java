package com.xh.system.infrastructure.mysql.service;

import com.github.yulichang.base.MPJBaseService;
import com.xh.common.core.entity.SysUserRecord;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 16:46
 */
public interface SysUserRecordService extends MPJBaseService<SysUserRecord> {
    
    SysUserRecord findByLoginAccount(String loginAccount, boolean enable);
    
}
