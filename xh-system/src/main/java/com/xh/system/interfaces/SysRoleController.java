package com.xh.system.interfaces;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.base.web.RestResponse;
import com.xh.system.api.request.RoleQueryRequest;
import com.xh.system.api.response.RoleQueryResponse;
import com.xh.system.application.command.sysrole.SysRoleDataPermission;
import com.xh.system.application.command.sysrole.SysRolePermissionDTO;
import com.xh.system.application.service.SysRoleService;
import com.xh.system.domain.entity.SysMenu;
import com.xh.system.domain.entity.SysRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/system/role")
@Tag(name = "系统角色管理")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;
    @PostMapping("/query")
    public RestResponse<PageResult<RoleQueryResponse>> query(@RequestBody PageQuery<RoleQueryRequest> request){
        return RestResponse.success(Optional.ofNullable(request).map(t -> sysRoleService.query(t)).orElse(null));
    }
    
    @Operation(description = "角色保存")
    @PostMapping("/save")
    public RestResponse<SysRole> save(@RequestBody SysRole sysRole) {
        return RestResponse.success(sysRoleService.save(sysRole));
    }

    @Operation(description = "获取角色详情")
    @GetMapping("/get/{id}")
    public RestResponse<SysRole> getById(@PathVariable Long id) {
        return RestResponse.success(sysRoleService.getById(id));
    }

    @Operation(description = "角色批量删除")
    @DeleteMapping("/del")
    public RestResponse<?> del(@RequestParam List<Long> ids) {
        sysRoleService.del(ids);
        return RestResponse.success();
    }

    @Operation(description = "查询角色可配置的所有菜单权限")
    @GetMapping("/queryRoleMenu")
    public RestResponse<List<SysMenu>> queryRoleMenu(@RequestParam Map<String, Object> param) {
        List<SysMenu> roleMenus = sysRoleService.queryRoleMenu(param);
        return RestResponse.success(roleMenus);
    }

    @Operation(description = "查询角色的数据权限")
    @GetMapping("/queryRoleDataPermission")
    public RestResponse<List<SysRoleDataPermission>> queryRoleDataPermission(SysRolePermissionDTO sysRolePermissionDTO) {
        List<SysRoleDataPermission> roleDataPermission = sysRoleService.queryRoleDataPermission(sysRolePermissionDTO);
        return RestResponse.success(roleDataPermission);
    }

    @Operation(description = "保存角色数据权限")
    @PostMapping("/saveRoleDataPermission")
    public RestResponse<?> saveRoleDataPermission(@RequestBody SysRolePermissionDTO sysRolePermissionDTO) {
        sysRoleService.saveRoleDataPermission(sysRolePermissionDTO);
        return RestResponse.success();
    }
}
