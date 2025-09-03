package com.xh.system.domain.repository.sysmenu;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xh.system.domain.aggregate.SysMenuAggregate;
import com.xh.common.base.constant.SysMenuConstant;
import com.xh.system.domain.entity.SysMenu;
import com.xh.system.domain.mapstract.sysmenu.SysMenuPO2EntityMapper;
import com.xh.system.domain.mapstract.sysuser.SysUserPO2EntityMapper;
import com.xh.system.domain.repository.sysmenu.factory.SysMenuRepositoryFactory;
import com.xh.system.infrastructure.mysql.po.SysRoleMenuPO;
import com.xh.system.infrastructure.mysql.po.SysRolePO;
import com.xh.system.infrastructure.mysql.service.SysMenuPOService;
import com.xh.system.infrastructure.mysql.service.SysRoleMenuPOService;
import com.xh.system.infrastructure.mysql.service.SysRolePOService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:23
 */
public abstract class AbstractSysMenuRepository {

    @Resource
    private SysMenuPOService sysMenuPOService;

    @Resource
    private SysRoleMenuPOService roleMenuPOService;

    @Resource
    private SysRolePOService sysRolePOService;

    public static AbstractSysMenuRepository getRepository(SysMenuConstant.SysMenuRootType type) {
        return SysMenuRepositoryFactory.getRepository(type.getType());
    }

    protected abstract SysMenuConstant.SysMenuRootType getType();

    @PostConstruct
    private void init() {
        SysMenuRepositoryFactory.SYS_MENU_REPOSITORY_MAP.put(getType().getType(), this);
    }

    public SysMenuAggregate findByRootId(Long rootId) {
        if (rootId == null) {
            return null;
        }
        SysRolePO rolePO = sysRolePOService.getById(rootId);
        if (rolePO == null) {
            return null;
        }
        LambdaQueryWrapper<SysRoleMenuPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRoleMenuPO::getSysRoleId, rolePO.getId());
        List<SysRoleMenuPO> roleMenuPOList = roleMenuPOService.list(queryWrapper);

        List<Long> menuIdList = roleMenuPOList.stream().map(SysRoleMenuPO::getSysMenuId).filter(Objects::nonNull).distinct().collect(Collectors.toList());

        SysMenuAggregate root = new SysMenuAggregate();
        root.setRootId(rootId);
        root.setSysRole(SysUserPO2EntityMapper.INSTANCE.role2Entity(rolePO));
        root.setSysRoleMenuList(SysMenuPO2EntityMapper.INSTANCE.sysRoleMenuPO2Entity(roleMenuPOList));
        root.setSysMenuList(menuByIdList(menuIdList));
        return root;

    }

    protected List<SysMenu> menuByIdList(List<Long> menuIdList) {
        if (CollUtil.isEmpty(menuIdList)) {
            return List.of();
        }
        return SysMenuPO2EntityMapper.INSTANCE.sysMenuPO2Entity(sysMenuPOService.listByIds(menuIdList));
    }
}
