package com.xh.system.application.mapstract;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.response.RoleQueryResponse;
import com.xh.system.domain.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SysRoleEntity2ResponseMapper {

    SysRoleEntity2ResponseMapper INSTANCE = Mappers.getMapper(SysRoleEntity2ResponseMapper.class);


    @Mappings(
            {
                    @Mapping(source = "records", target = "list"),
                    @Mapping(source = "total", target = "total"),
                    @Mapping(source = "current", target = "currentPage"),
                    @Mapping(source = "size", target = "pageSize"),
            })
    PageResult<RoleQueryResponse> pageEntity2PageResult(Page<SysRole> page);
}
