package com.xh.system.domain.repository.sysuser.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import com.xh.system.infrastructure.mysql.po.SysOrgPO;
import org.springframework.stereotype.Service;

@Service
public class SysUserWithOrgRepositoryImpl extends AbstractSysUserRepository {
    @Override
    protected SysUserConstant.SysUserRootType getType() {
        return SysUserConstant.SysUserRootType.ORG;
    }
    
    public Page<SysOrg> sysOrgPageQuery(int current, int pageSize, LambdaQueryWrapper<SysOrgPO> lambdaQueryWrapper){
        if(current <= 0 || pageSize <= 0 || lambdaQueryWrapper == null){
            return new Page<>();
        }
        Page<SysOrgPO> page = getSysOrgPOService().page(new Page<>(current, pageSize), lambdaQueryWrapper);
        return getSysUserPO2EntityMapper().org2EntityList(page);
    }
}
