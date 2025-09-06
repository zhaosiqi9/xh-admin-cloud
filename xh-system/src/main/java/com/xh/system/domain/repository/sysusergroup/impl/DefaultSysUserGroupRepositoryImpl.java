package com.xh.system.domain.repository.sysusergroup.impl;

import com.xh.common.base.constant.SysUserGroupConstant;
import com.xh.system.domain.repository.sysusergroup.AbstractSysUserGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultSysUserGroupRepositoryImpl extends AbstractSysUserGroupRepository {

    @Override
    protected SysUserGroupConstant.UserGroupMemberRootType getType() {
        return SysUserGroupConstant.UserGroupMemberRootType.DEFAULT;
    }
}
