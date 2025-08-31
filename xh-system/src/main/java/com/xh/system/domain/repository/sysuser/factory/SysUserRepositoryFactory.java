package com.xh.system.domain.repository.sysuser.factory;

import com.xh.common.base.constant.SysUserConstant;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 17:47
 */
public class SysUserRepositoryFactory {

    public static final Map<String, AbstractSysUserRepository> SYS_USER_REPOSITORY_MAP = new HashMap<>();

    public static AbstractSysUserRepository getRepository(String type) {
        AbstractSysUserRepository repository = SYS_USER_REPOSITORY_MAP.get(type);
        return Optional.ofNullable(repository).orElse(SYS_USER_REPOSITORY_MAP.get(SysUserConstant.SysUserRootType.DEFAULT.getType()));
    }
}
