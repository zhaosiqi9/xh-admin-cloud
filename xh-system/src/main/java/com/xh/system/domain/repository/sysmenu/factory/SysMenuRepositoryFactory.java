package com.xh.system.domain.repository.sysmenu.factory;

import com.xh.system.domain.repository.sysmenu.AbstractSysMenuRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:24
 */
public class SysMenuRepositoryFactory {

    public static final Map<String, AbstractSysMenuRepository> SYS_MENU_REPOSITORY_MAP = new HashMap<>();
    
    public static AbstractSysMenuRepository getRepository(String type) {
        return SYS_MENU_REPOSITORY_MAP.get(type);
    }
}
