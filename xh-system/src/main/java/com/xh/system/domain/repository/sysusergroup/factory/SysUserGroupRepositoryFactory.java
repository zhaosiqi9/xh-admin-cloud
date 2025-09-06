package com.xh.system.domain.repository.sysusergroup.factory;

import com.xh.common.base.constant.SysUserGroupMemberConstant;
import com.xh.system.domain.repository.sysusergroup.AbstractSysUserGroupRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author : gr
 * @version 1.0.0
 * @date : 2025/9/6 21:44
 */
public class SysUserGroupRepositoryFactory {
    
     public static final Map<String, AbstractSysUserGroupRepository> SYS_USER_GROUP_REPOSITORY_MAP = new HashMap<>();

    public static AbstractSysUserGroupRepository getRepository(String type) {
        AbstractSysUserGroupRepository repository = SYS_USER_GROUP_REPOSITORY_MAP.get(type);
        return Optional.ofNullable(repository).orElse(SYS_USER_GROUP_REPOSITORY_MAP.get(SysUserGroupMemberConstant.UserGroupMemberRootType.DEFAULT.getType()));
    }
    
}
