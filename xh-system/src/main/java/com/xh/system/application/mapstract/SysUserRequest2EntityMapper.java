package com.xh.system.application.mapstract;

import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.domain.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 00:27
 */
@Mapper(componentModel = "spring")
public interface SysUserRequest2EntityMapper {

    SysUserRequest2EntityMapper INSTANCE = Mappers.getMapper(SysUserRequest2EntityMapper.class);
    
    SysUser toEntity(GetUserInfoResponse request);
}
