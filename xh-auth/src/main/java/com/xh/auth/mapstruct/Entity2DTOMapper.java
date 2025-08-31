package com.xh.auth.mapstruct;

import com.xh.jwt.dto.SysMenuDTO;
import com.xh.jwt.dto.SysOrgRoleDTO;
import com.xh.system.api.response.GetUserInfoResponseJob;
import com.xh.system.api.response.UserPermissionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 00:43
 */
@Mapper(componentModel = "spring")
public interface Entity2DTOMapper {

    Entity2DTOMapper INSTANCE = Mappers.getMapper(Entity2DTOMapper.class);

    List<SysOrgRoleDTO> toSysOrgRoleDTOList(List<GetUserInfoResponseJob> jobList);

    SysOrgRoleDTO toSysOrgRoleDTO(GetUserInfoResponseJob job);

    List<SysMenuDTO> permissionList2SysMenuDTOList(List<UserPermissionResponse> permissions);
}
