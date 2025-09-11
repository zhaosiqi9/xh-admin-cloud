package com.xh.system.interfaces;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.RestResponse;
import com.xh.common.core.api.contract.RemotePermissionContract;
import com.xh.system.application.service.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/31 20:28
 */
@Tag(name = "权限管理")
@RestController
@RequestMapping("/api/system/permission")
public class PermissionController implements RemotePermissionContract {

    @Resource
    private PermissionService permissionService;
    
    @Override
    public List<String> getPermissionList(Long loginId, String loginType) {
        if (loginId == null) {
            return List.of();
        }
        return permissionService.getMenuPermission(loginId, loginType);
    }

    @Override
    public List<String> getRoleList(Long loginId, String loginType) {
        if (loginId == null) {
            return List.of();
        }
        return permissionService.getRoleList(loginId, loginType);
    }
    
/*     @Operation(description = "数据实体列表查询")
    @PostMapping("/entity/query")
    public RestResponse<List<SysDataEntity>> queryEntity() {
        List<SysDataEntity> data = sysDataPermissionService.queryEntity();
        return RestResponse.success(data);
    }

    @Operation(description = "数据权限列表查询")
    @PostMapping("/query")
    public RestResponse<PageResult<SysDataPermission>> query(@RequestBody PageQuery<Map<String, Object>> pageQuery) {
        PageResult<SysDataPermission> data = sysDataPermissionService.query(pageQuery);
        return RestResponse.success(data);
    }

    @SaCheckPermission(value = {"system:dataPermission:add", "system:dataPermission:edit"}, mode = SaMode.OR)
    @Operation(description = "数据权限保存")
    @PostMapping("/save")
    public RestResponse<SysDataPermission> save(@RequestBody SysDataPermission sysDataPermission) {
        return RestResponse.success(sysDataPermissionService.save(sysDataPermission));
    }

    @SaCheckPermission(value = {"system:dataPermission:edit", "system:dataPermission:detail"}, mode = SaMode.OR)
    @Operation(description = "获取数据权限详情")
    @GetMapping("/get/{id}")
    public RestResponse<SysDataPermission> getById(@PathVariable Integer id) {
        return RestResponse.success(sysDataPermissionService.getById(id));
    }

    @SaCheckPermission("system:dataPermission:del")
    @Operation(description = "数据权限批量删除")
    @DeleteMapping("/del")
    public RestResponse<?> del(@RequestParam List<Integer> ids) {
        sysDataPermissionService.del(ids);
        return RestResponse.success();
    }*/
}
