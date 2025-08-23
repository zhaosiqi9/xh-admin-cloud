package com.xh.system.domain.mapstract.sysmenu;

import com.xh.system.domain.entity.SysMenu;
import com.xh.system.domain.entity.SysRoleMenu;
import com.xh.system.infrastructure.mysql.po.SysMenuPO;
import com.xh.system.infrastructure.mysql.po.SysRoleMenuPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:40
 */
@Mapper(componentModel = "spring")
public interface SysMenuPO2EntityMapper {
    
    SysMenuPO2EntityMapper INSTANCE = Mappers.getMapper(SysMenuPO2EntityMapper.class);
    
    List<SysRoleMenu> sysRoleMenuPO2Entity(List<SysRoleMenuPO> poList);

    List<SysMenu> sysMenuPO2Entity(List<SysMenuPO> poList);
}
