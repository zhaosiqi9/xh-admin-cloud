package com.xh.system.interfaces;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.base.web.RestResponse;
import com.xh.common.core.annotation.Log;
import com.xh.system.api.contract.RemoteSysMenuContract;
import com.xh.system.api.request.user.UserPermissionRequest;
import com.xh.system.api.response.UserPermissionResponse;
import com.xh.system.application.service.SysMenuService;
import com.xh.system.domain.entity.SysMenu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Tag(name = "菜单管理")
@RestController
@RequestMapping("/api/system/menu")
public class SysMenuController implements RemoteSysMenuContract {

    @Resource
    private SysMenuService sysMenuService;

    @Log
    @Override
    public RestResponse<List<UserPermissionResponse>> rolePermissionList(UserPermissionRequest request) {
        return RestResponse.success(
                Optional.ofNullable(request)
                        .map(t -> sysMenuService.rolePermissionList(t))
                        .orElse(List.of())
        );
    }


    @Operation(description = "菜单列表查询")
    @PostMapping("/query")
    public RestResponse<PageResult<SysMenu>> query(@RequestBody PageQuery<Map<String, Object>> pageQuery) {
        PageResult<SysMenu> data = sysMenuService.query(pageQuery);
        return RestResponse.success(data);
    }

    @SaCheckPermission(value = {"system:menu:add", "system:menu:edit"}, mode = SaMode.OR)
    @Operation(description = "切换菜单字段值")
    @PostMapping("/switch_prop")
    public RestResponse<PageResult<SysMenu>> switchMenuProp(@RequestBody Map<String, Object> param) {
        sysMenuService.switchMenuProp(param);
        return RestResponse.success();
    }

    @SaCheckPermission(value = {"system:menu:add", "system:menu:edit"}, mode = SaMode.OR)
    @Operation(description = "菜单保存")
    @PostMapping("/save")
    public RestResponse<SysMenu> save(@RequestBody SysMenu sysMenu) {
        return RestResponse.success(sysMenuService.save(sysMenu));
    }

    @SaCheckPermission(value = {"system:menu:edit", "system:menu:detail"}, mode = SaMode.OR)
    @Operation(description = "获取菜单详情")
    @GetMapping("/get/{id}")
    public RestResponse<SysMenu> getById(@PathVariable Long id) {
        return RestResponse.success(sysMenuService.getById(id));
    }

    @SaCheckPermission("system:menu:del")
    @Operation(description = "菜单批量删除")
    @DeleteMapping("/del")
    public RestResponse<?> del(@RequestParam List<Long> ids) {
        sysMenuService.del(ids);
        return RestResponse.success();
    }
}
