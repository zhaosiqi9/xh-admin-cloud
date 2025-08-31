package com.xh.system.application.mapstract;

import com.xh.jwt.dto.SysMenuDTO;
import com.xh.system.api.response.UserPermissionResponse;
import com.xh.system.domain.aggregate.SysMenuAggregate;
import com.xh.system.domain.entity.SysMenu;
import com.xh.system.domain.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:54
 */
@Mapper(componentModel = "spring")
public interface SysMenuEntity2ResponseMapper {
    
    SysMenuEntity2ResponseMapper INSTANCE = Mappers.getMapper(SysMenuEntity2ResponseMapper.class);

    default List<UserPermissionResponse> toUserPermissionResponse(SysMenuAggregate root){
        SysRole role = root.getSysRole();
        Map<Long, SysMenu> menuMap = root.getSysMenuList().stream().collect(Collectors.toMap(SysMenu::getId, Function.identity(), (r, s) -> r));
        return root.getSysRoleMenuList().stream().map(roleMenu -> {
            SysMenu menu = menuMap.getOrDefault(roleMenu.getSysMenuId(), new SysMenu());
            UserPermissionResponse response = new UserPermissionResponse();
            response.setId(menu.getId());
            response.setRoleId(role.getId());
            response.setParentId(menu.getParentId());
            response.setTitle(menu.getTitle());
            response.setName(menu.getName());
            response.setPath(menu.getPath());
            response.setComponent(menu.getComponent());
            response.setPlatform(menu.getPlatform());
            response.setType(menu.getType());
            response.setHandleType(menu.getHandleType());
            response.setOuterUrl(menu.getOuterUrl());
            response.setIcon(menu.getIcon());
            response.setOrder(menu.getOrder());
            response.setCache(menu.getCache());
            response.setEnabled(menu.getEnabled());
            response.setCreateTime(menu.getCreateTime());
            response.setUpdateTime(menu.getUpdateTime());
            response.setCreateBy(menu.getCreateBy());
            response.setUpdateBy(menu.getUpdateBy());
            return response;
        }).toList();
    }

    List<UserPermissionResponse> rolePermission2UserPermissionResponse(List<SysMenuDTO> permissions);
}
