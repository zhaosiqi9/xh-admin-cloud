package com.xh.system.application.mapstract;

import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.domain.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 09:23
 */
@Mapper(componentModel = "spring")
public interface SysUserEntity2ResponseMapper {
    
    SysUserEntity2ResponseMapper INSTANCE = Mappers.getMapper(SysUserEntity2ResponseMapper.class);

    GetUserInfoResponse toGetUserInfoResponse(SysUser sysUser);
}
