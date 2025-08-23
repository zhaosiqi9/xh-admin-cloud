package com.xh.system.application.mapstract;

import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.request.UpdateUserInfoRequest;
import com.xh.system.application.command.sysuser.GetUserInfoCommand;
import com.xh.system.application.command.sysuser.UpdateUserInfoCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 00:27
 */
@Mapper(componentModel = "spring")
public interface SysUserRequest2CommandMapper {

    SysUserRequest2CommandMapper INSTANCE = Mappers.getMapper(SysUserRequest2CommandMapper.class);

    @Mapping(target = "type", source = "type")
    UpdateUserInfoCommand updateUserInfoRequest2Command(UpdateUserInfoRequest request);

    @Mapping(target = "type", source = "type")
    GetUserInfoCommand getUserInfoRequest2Command(GetUserInfoRequest request);
}
