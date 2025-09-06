package com.xh.system.domain.service;

import com.xh.common.base.constant.SysUserGroupConstant;
import com.xh.system.domain.entity.SysUserGroup;
import com.xh.system.domain.repository.sysusergroup.AbstractSysUserGroupRepository;
import com.xh.system.domain.repository.sysusergroup.factory.SysUserGroupRepositoryFactory;
import org.springframework.stereotype.Service;

@Service
public class SysUserGroupDomainService {

    public static AbstractSysUserGroupRepository getRepository(SysUserGroupConstant.UserGroupMemberRootType rootType) {
        return SysUserGroupRepositoryFactory.getRepository(rootType.getType());
    }

    public void saveUserGroup(SysUserGroup sysUserGroup) {
        
    }

    public void updateUserGroup(SysUserGroup sysUserGroup) {
        
    }
}
