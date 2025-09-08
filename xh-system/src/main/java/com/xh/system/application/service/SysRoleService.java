package com.xh.system.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.request.RoleQueryRequest;
import com.xh.system.api.request.role.SysRoleSaveRequest;
import com.xh.system.api.response.RoleQueryResponse;
import com.xh.system.application.command.sysrole.RoleQueryCommand;
import com.xh.system.application.command.sysrole.SysRoleDataPermission;
import com.xh.system.application.command.sysrole.SysRolePermissionDTO;
import com.xh.system.application.mapstract.SysRoleEntity2ResponseMapper;
import com.xh.system.domain.entity.SysMenu;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysRoleMenu;
import com.xh.system.domain.service.SysMenuDomainService;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.infrastructure.mysql.po.SysRolePO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysRoleService {

    @Resource
    private SysUserDomainService sysUserDomainService;

    @Resource
    private SysMenuDomainService sysMenuDomainService;
    
    public PageResult<RoleQueryResponse> query(PageQuery<RoleQueryRequest> request) {
        MPJLambdaWrapper<SysRolePO> lambdaWrapper = RoleQueryCommand.initQueryWrapper(request);
        
        Page<SysRole> rolePage = SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.ROLE).sysRolePageQuery(request.getCurrentPage(),
                request.getPageSize(), lambdaWrapper);
        return SysRoleEntity2ResponseMapper.INSTANCE.pageEntity2PageResult(rolePage);
        
    }

    public void del(List<Long> ids) {
        
    }

    public SysRole getById(Long id) {
        return null;
    }

    public SysRole save(SysRoleSaveRequest sysRole) {
        
        if(sysRole.getId())
        
        if (sysRole.getId() == null) {
            baseJdbcDao.insert(sysRole);
        } else {
            //删除之前的权限
            String sql = "delete from sys_role_menu where sys_role_id = ?";
            primaryJdbcTemplate.update(sql, sysRole.getId());
            baseJdbcDao.update(sysRole);
        }
        List<SysRoleMenu> roleMenus = sysRole.getRoleMenus();
        for (SysRoleMenu roleMenu : roleMenus) {
            roleMenu.setSysRoleId(sysRole.getId());
            baseJdbcDao.insert(roleMenu);
        }
        //需要删除子级角色多出的权限（mysql8.0递归查询并删除）
        String sql2 = """
                WITH recursive tb as (
                	SELECT * from sys_role where parent_id = ?
                	UNION ALL
                	SELECT b.* from tb inner join sys_role b on b.parent_id = tb.id
                )
                DELETE FROM sys_role_menu
                WHERE sys_role_id IN ( SELECT id FROM tb )
                    AND sys_menu_id NOT IN (
                     select * from (select sys_menu_id from sys_role_menu where sys_role_id = ?) temp
                    )
                """;
        primaryJdbcTemplate.update(sql2, sysRole.getId(), sysRole.getId());

        //刷新角色权限
        commonService.getRolePermissions(sysRole.getId(), true);
        return sysRole;
    }

    public List<SysMenu> queryRoleMenu(Map<String, Object> param) {
        return null;
    }

    public List<SysRoleDataPermission> queryRoleDataPermission(SysRolePermissionDTO sysRolePermissionDTO) {
        return null;
    }

    public void saveRoleDataPermission(SysRolePermissionDTO sysRolePermissionDTO) {
        
    }
}
