package com.xh.system.domain.repository.sysusergroup;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.constant.SysUserGroupConstant;
import com.xh.system.domain.aggregate.SysUserGroupAggregate;
import com.xh.system.domain.entity.SysUserGroup;
import com.xh.system.domain.entity.SysUserGroupMember;
import com.xh.system.domain.mapstract.sysgroupmember.SysUserGroupPO2EntityMapper;
import com.xh.system.domain.repository.sysusergroup.factory.SysUserGroupRepositoryFactory;
import com.xh.system.infrastructure.mysql.po.SysUserGroupMemberPO;
import com.xh.system.infrastructure.mysql.po.SysUserGroupPO;
import com.xh.system.infrastructure.mysql.service.SysUserGroupMemberPOService;
import com.xh.system.infrastructure.mysql.service.SysUserGroupPOService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public abstract class AbstractSysUserGroupRepository {

    @Resource
    private SysUserGroupPOService sysUserGroupPOService;

    @Resource
    private SysUserGroupMemberPOService sysUserGroupMemberPOService;

    @Resource
    private SysUserGroupPO2EntityMapper sysUserGroupPO2EntityMapper;

    protected abstract SysUserGroupConstant.UserGroupMemberRootType getType();

    @PostConstruct
    protected void init() {
        SysUserGroupRepositoryFactory.SYS_USER_GROUP_REPOSITORY_MAP.put(getType().getType(), this);
    }

    public SysUserGroupAggregate findByRootId(Long rootId) {
        if (rootId == null) {
            return null;
        }
        SysUserGroupAggregate root = new SysUserGroupAggregate();
        root.setRootId(rootId);
        root.setSysUserGroup(findMainByRootId(rootId));
        root.setSysUserGroupMemberList(findMemberByRootId(rootId));
        return root;
    }

    protected SysUserGroup findMainByRootId(Long rootId) {
        SysUserGroupPO sysUserGroupPO = sysUserGroupPOService.getById(rootId);
        return sysUserGroupPO2EntityMapper.sysUserGroupPo2Entity(sysUserGroupPO);
    }

    protected List<SysUserGroupMember> findMemberByRootId(Long rootId) {
        LambdaQueryWrapper<SysUserGroupMemberPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserGroupMemberPO::getSysUserGroupId, rootId);

        List<SysUserGroupMemberPO> sysUserGroupMemberPOList = sysUserGroupMemberPOService.list(lambdaQueryWrapper);
        return sysUserGroupPO2EntityMapper.sysUserGroupMemberPoList2Entity(sysUserGroupMemberPOList);
    }

    public Page<SysUserGroup> queryUserGroupPage(int currentPage, int pageSize, String code, String name) {
        LambdaQueryWrapper<SysUserGroupPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
//                .like(SysUserGroupPO::getCode, code)
                .like(SysUserGroupPO::getName, name);
        Page<SysUserGroupPO> page = sysUserGroupPOService.page(new Page<>(currentPage, pageSize), lambdaQueryWrapper);
        return sysUserGroupPO2EntityMapper.sysUserGroupPoPage2Entity(page);
    }
}
