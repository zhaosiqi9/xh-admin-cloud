package com.xh.system.domain.mapstract.sysuser;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.system.domain.entity.*;
import com.xh.system.infrastructure.mysql.po.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 21:26
 */
@Mapper(componentModel = "spring")
public interface SysUserPO2EntityMapper {

    SysUserPO2EntityMapper INSTANCE = Mappers.getMapper(SysUserPO2EntityMapper.class);

    SysUser user2Entity(SysUserPO po);

    List<SysUserJob> userJob2EntityList(List<SysUserJobPO> poList);
    List<SysUserGroupMember> userGroupMember2EntityList(List<SysUserGroupMemberPO> poList);

    List<SysOrg> org2EntityList(List<SysOrgPO> poList);

    List<SysRole> role2EntityList(List<SysRolePO> poList);

    SysRole role2Entity(SysRolePO po);
    
    Page<SysOrg> org2EntityList(Page<SysOrgPO> poList);
}
