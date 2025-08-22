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
public interface SysUserEntity2RecordMapper {

    SysUserEntity2RecordMapper INSTANCE = Mappers.getMapper(SysUserEntity2RecordMapper.class);

    SysUserRecord toRecord(SysUser sysUser);
}
