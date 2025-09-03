package com.xh.system.application.mapstract;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.response.OrgQueryResponse;
import com.xh.system.domain.entity.SysOrg;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SysOrgEntity2ResponseMapper {

    SysOrgEntity2ResponseMapper INSTANCE = Mappers.getMapper(SysOrgEntity2ResponseMapper.class);

    @Mappings(
            {
                    @Mapping(source = "records", target = "list"),
                    @Mapping(source = "total", target = "total"),
                    @Mapping(source = "current", target = "currentPage"),
                    @Mapping(source = "size", target = "pageSize"),
            })
    PageResult<OrgQueryResponse> pageEntity2PageResult(Page<SysOrg> entity);
}
