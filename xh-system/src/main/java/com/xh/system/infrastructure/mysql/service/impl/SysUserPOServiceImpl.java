package com.xh.system.infrastructure.mysql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.xh.system.infrastructure.mysql.mapper.SysUserPOMapper;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import com.xh.system.infrastructure.mysql.service.SysUserPOService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 16:46
 */
@Service
public class SysUserPOServiceImpl extends MPJBaseServiceImpl<SysUserPOMapper, SysUserPO> implements SysUserPOService {

    @Override
    public SysUserPO findByLoginAccount(String loginAccount, boolean enable) {
        if (loginAccount == null) {
            return null;
        }
        LambdaQueryWrapper<SysUserPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserPO::getCode, loginAccount);
        lambdaQueryWrapper.eq(SysUserPO::getEnabled, enable);
        List<SysUserPO> list = this.list(lambdaQueryWrapper);
        return Optional.ofNullable(list).map(t -> {
            if (t.size() > 1) {
                throw new RuntimeException("登录账号重复");
            }
            return list.getFirst();
        }).orElse(null);
    }
}
