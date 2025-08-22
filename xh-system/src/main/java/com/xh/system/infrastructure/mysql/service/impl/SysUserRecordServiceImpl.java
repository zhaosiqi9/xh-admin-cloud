package com.xh.system.infrastructure.mysql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.xh.common.core.entity.SysUserRecord;
import com.xh.system.infrastructure.mysql.mapper.SysUserMapper;
import com.xh.system.infrastructure.mysql.service.SysUserRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 16:46
 */
@Service
public class SysUserRecordServiceImpl extends MPJBaseServiceImpl<SysUserMapper, SysUserRecord> implements SysUserRecordService {

    @Override
    public SysUserRecord findByLoginAccount(String loginAccount, boolean enable) {
        if (loginAccount==null) {
            return null;
        }
        LambdaQueryWrapper<SysUserRecord> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserRecord::getCode, loginAccount);
        lambdaQueryWrapper.eq(SysUserRecord::getEnabled, enable);
        List<SysUserRecord> list = this.list(lambdaQueryWrapper);
        return Optional.ofNullable(list).map(t -> {
            if (t.size() > 1) {
                throw new RuntimeException("登录账号重复");
            }
            return list.getFirst();
        }).orElse(null);
    }
}
