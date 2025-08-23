package com.xh.system.infrastructure.mysql.service;

import com.github.yulichang.base.MPJBaseService;
import com.xh.system.infrastructure.mysql.po.SysUserPO;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 16:46
 */
public interface SysUserPOService extends MPJBaseService<SysUserPO> {
    
    SysUserPO findByLoginAccount(String loginAccount, boolean enable);
    
}
