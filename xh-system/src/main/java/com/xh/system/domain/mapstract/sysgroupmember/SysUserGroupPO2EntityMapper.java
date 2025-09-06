package com.xh.system.domain.mapstract.sysgroupmember;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.system.domain.entity.SysUserGroup;
import com.xh.system.domain.entity.SysUserGroupMember;
import com.xh.system.infrastructure.mysql.po.SysUserGroupMemberPO;
import com.xh.system.infrastructure.mysql.po.SysUserGroupPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SysUserGroupPO2EntityMapper {
    
    SysUserGroupPO2EntityMapper INSTANCE = Mappers.getMapper(SysUserGroupPO2EntityMapper.class);
    
    List<SysUserGroupMember> sysUserGroupMemberPoList2Entity(List<SysUserGroupMemberPO> po);
    
    SysUserGroup sysUserGroupPo2Entity(SysUserGroupPO po);

    Page<SysUserGroup> sysUserGroupPoPage2Entity(Page<SysUserGroupPO> page);

    List<SysUserGroup> sysUserGroupPoList2Entity(List<SysUserGroupPO> list);
}
