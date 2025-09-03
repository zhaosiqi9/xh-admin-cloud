package com.xh.system.domain.mapstract.sysuser;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserJob;
import com.xh.system.infrastructure.mysql.po.SysOrgPO;
import com.xh.system.infrastructure.mysql.po.SysRolePO;
import com.xh.system.infrastructure.mysql.po.SysUserJobPO;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
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

    List<SysOrg> userOrg2EntityList(List<SysOrgPO> poList);

    List<SysRole> userRole2EntityList(List<SysRolePO> poList);

    SysRole userRole2Entity(SysRolePO po);
    
    Page<SysOrg> userOrg2EntityList(Page<SysOrgPO> poList);
}
