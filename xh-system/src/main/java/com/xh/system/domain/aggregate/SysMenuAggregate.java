package com.xh.system.domain.aggregate;

import com.xh.system.domain.entity.SysMenu;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysRoleMenu;
import lombok.Data;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:10
 */
@Data
public class SysMenuAggregate {

    private Long rootId;

    private SysRole sysRole;

    private List<SysRoleMenu> sysRoleMenuList = List.of();
    
    private List<SysMenu> sysMenuList = List.of();
}
