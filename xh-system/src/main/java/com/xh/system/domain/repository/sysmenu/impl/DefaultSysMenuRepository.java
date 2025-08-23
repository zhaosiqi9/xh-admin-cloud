package com.xh.system.domain.repository.sysmenu.impl;

import com.xh.system.domain.constant.sysmenu.SysMenuConstant;
import com.xh.system.domain.repository.sysmenu.AbstractSysMenuRepository;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:27
 */
@Service
public class DefaultSysMenuRepository extends AbstractSysMenuRepository {

    @Override
    protected SysMenuConstant.SysMenuRootType getType() {
        return SysMenuConstant.SysMenuRootType.DEFAULT;
    }
}
