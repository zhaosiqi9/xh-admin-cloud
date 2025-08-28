package com.xh.system.interfaces;

import com.xh.common.core.annotation.Log;
import com.xh.common.core.web.PageResult;
import com.xh.common.core.web.RestResponse;
import com.xh.system.api.contract.RemoteSysUserContract;
import com.xh.system.api.request.*;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.SwitchUserRoleResponse;
import com.xh.system.api.response.SystemUserQueryResponse;
import com.xh.system.application.mapstract.SysUserRequest2CommandMapper;
import com.xh.system.application.service.SysUserService;
import com.xh.system.domain.entity.SysUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/system/user")
public class SysUserController implements RemoteSysUserContract {
    @Resource
    private SysUserService sysUserService;

    @Autowired
    private SysUserRequest2CommandMapper sysUserRequest2CommandMapper;

    @Log
    @Operation(description = "获取用户信息")
    @Override
    public GetUserInfoResponse getUserInfo(GetUserInfoRequest request) {
        return Optional.ofNullable(request)
                .map(t -> sysUserRequest2CommandMapper.getUserInfoRequest2Command(t))
                .map(t -> sysUserService.getUserInfo(t))
                .orElse(null);
    }

    @Log
    @Operation(description = "清空登录失败次数")
    @Override
    public boolean clearFailuresNum(UpdateUserInfoRequest request) {
        return Optional.ofNullable(request)
                .map(t -> sysUserRequest2CommandMapper.updateUserInfoRequest2Command(t))
                .map(t -> sysUserService.clearFailuresNum(t))
                .orElse(false);
    }

    @Log
    @Operation(description = "登录失败更新用户信息")
    @Override
    public boolean loginFailUpdateInfo(UpdateUserInfoRequest request) {
        return Optional.ofNullable(request)
                .map(t -> sysUserRequest2CommandMapper.updateUserInfoRequest2Command(t))
                .map(t -> sysUserService.loginFailUpdateInfo(t))
                .orElse(false);

    }

    @Log
    @Operation(description = "角色切换")
    @PostMapping("/switchUserRole")
    public RestResponse<SwitchUserRoleResponse> switchUserRole(@RequestBody SwitchUserRoleRequest request) {
        return RestResponse.success(sysUserService.switchUserRole(request));
    }

    @Log
    @Operation(description = "查询用户")
    @PostMapping("/query")
    public RestResponse<PageResult<SystemUserQueryResponse>> query(@RequestBody SystemUserQueryRequest request) {
        return RestResponse.success(sysUserService.query(request));
    }

    @Log
    @Operation(description = "用户保存")
    @PostMapping("/save")
    public RestResponse<SysUser> save(@RequestBody SaveSysUserRequest request) {
        return RestResponse.success(Optional.ofNullable(request)
                .map(t -> sysUserRequest2CommandMapper.saveSysUserRequest2Command(t))
                .map(t -> sysUserService.save(t)).orElse(null));
    }
}
