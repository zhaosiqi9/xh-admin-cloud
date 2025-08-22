package com.xh.system.domain.mapstract.sysuser;

import com.xh.common.core.entity.SysUserRecord;
import com.xh.system.domain.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 21:26
 */
@Mapper(componentModel = "spring")
public interface SysUserRecord2EntityMapper {

    SysUserRecord2EntityMapper INSTANCE = Mappers.getMapper(SysUserRecord2EntityMapper.class);

    SysUser toEntity(SysUserRecord sysUserRecord);
}
