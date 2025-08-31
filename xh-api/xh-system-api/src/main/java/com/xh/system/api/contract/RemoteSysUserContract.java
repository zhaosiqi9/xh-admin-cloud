package com.xh.system.api.contract;

import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.request.RolePermissionsListRequest;
import com.xh.system.api.request.UpdateUserInfoRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.RolePermissionsListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 12:45
 */
@FeignClient(contextId = "remoteSysUserService", value = "xh-system", path = "/api/system/user")
@Tag(name = "用户管理")
public interface RemoteSysUserContract {

    /**
     * 获取用户信息
     *
     * @param request 请求参数
     * @return 用户信息
     */
    @Operation(description = "获取用户信息")
    @PostMapping("get-user-info")
    GetUserInfoResponse getUserInfo(@RequestBody GetUserInfoRequest request);
    
    @Operation(description = "角色权限列表")
    @PostMapping("role-permission-list")
    List<RolePermissionsListResponse> rolePermissionList(@RequestBody RolePermissionsListRequest request);
    

    /**
     * 清空登录失败次数
     *
     * @param request 登录失败次数
     * @return 是否成功
     */
    @Operation(description = "清空登录失败次数")
    @PostMapping("clear-failures-num")
    boolean clearFailuresNum(@RequestBody UpdateUserInfoRequest request);

    /**
     * 登录失败更新用户信息
     *
     * @param request 登录失败次数
     * @return 是否成功
     */
    @Operation(description = "登录失败更新用户信息")
    @PostMapping("login-fail-update-info")
    boolean loginFailUpdateInfo(@RequestBody UpdateUserInfoRequest request);

}
