package com.xh.system.domain.repository.sysuser.impl;

import com.xh.common.core.entity.BaseEntity;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.sysuser.SysUserConstant;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserJob;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 22:39
 */
@Slf4j
@Service
public class SysUserWithJobRepositoryImpl extends AbstractSysUserRepository {
    @Override
    protected SysUserConstant.SysUserRootType getType() {
        return SysUserConstant.SysUserRootType.ORG_ROLE;
    }

    @Override
    public SysUserAggregate findByRootId(Long rootId) {
        if (rootId == null) {
            return null;
        }
        SysUserAggregate root = new SysUserAggregate();
        SysUser sysUser = findMainByRootId(rootId);
        if (sysUser == null) {
            return null;
        }
        rootId = sysUser.getId();

        List<SysUserJob> userJobList = findUserJobListByRootId(rootId);
        List<SysOrg> orgList = findUserOrgListByRootId(rootId, userJobList);
        List<SysRole> roleList = findUserRoleListByRootId(rootId, userJobList);

        Map<Long, SysOrg> orgMap = orgList.stream().collect(Collectors.toMap(BaseEntity::getId, Function.identity(), (r, s) -> r));
        Map<Long, SysRole> roleMap = roleList.stream().collect(Collectors.toMap(BaseEntity::getId, Function.identity(), (r, s) -> r));

        userJobList.forEach(t -> {
            t.setOrgCode(orgMap.getOrDefault(t.getSysOrgId(), new SysOrg()).getCode());
            t.setOrgName(orgMap.getOrDefault(t.getSysOrgId(), new SysOrg()).getName());
            t.setRoleName(roleMap.getOrDefault(t.getSysRoleId(), new SysRole()).getName());
        });

        root.setSysUser(sysUser);
        root.setRootId(rootId);
        root.setSysUserJobList(userJobList);
        root.setSysOrgList(orgList);
        root.setSysRoleList(roleList);
        return root;

    }


}
