package com.xh.system.api.contract;

import com.xh.common.base.web.RestResponse;
import com.xh.system.api.request.user.UserPermissionRequest;
import com.xh.system.api.response.UserPermissionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:15
 */
@Tag(name = "菜单管理")
@FeignClient(contextId = "remoteSysMenuContract", value = "xh-system", path = "/api/system/menu")
public interface RemoteSysMenuContract {

    /**
     * 角色权限列表
     *
     * @param request 用户权限请求
     * @return 角色权限列表
     */
    @Operation(description = "角色权限列表")
    @PostMapping("role-permission-list")
    RestResponse<List<UserPermissionResponse>> rolePermissionList(@Parameter(description = "用户权限请求") @RequestBody UserPermissionRequest request);

}
