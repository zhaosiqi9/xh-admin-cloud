package com.xh.system.domain.mapstract.sysuser;

import com.xh.system.domain.entity.SysUser;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 21:26
 */
@Mapper(componentModel = "spring")
public interface SysUserEntity2POMapper {

    SysUserEntity2POMapper INSTANCE = Mappers.getMapper(SysUserEntity2POMapper.class);

    SysUserPO toRecord(SysUser sysUser);
}
