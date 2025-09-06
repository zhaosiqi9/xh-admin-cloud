package com.xh.system.interfaces;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.base.web.RestResponse;
import com.xh.common.core.annotation.Log;
import com.xh.system.api.contract.RemoteSysUserContract;
import com.xh.system.api.request.*;
import com.xh.system.api.request.user.UserQueryUserGroupListRequest;
import com.xh.system.api.request.user.UserSwitchMenuPropRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.RolePermissionsListResponse;
import com.xh.system.api.response.SwitchUserRoleResponse;
import com.xh.system.api.response.SystemUserQueryResponse;
import com.xh.system.application.mapstract.SysUserRequest2CommandMapper;
import com.xh.system.application.service.SysUserService;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<RolePermissionsListResponse> rolePermissionList(RolePermissionsListRequest request) {
        return List.of();
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


    @Log
    @Operation(description = "测试")
    @PostMapping("/test")
    public SaResult test() {
        System.out.println("是否登录：" + StpUtil.isLogin());
        System.out.println("tokenValue：" + StpUtil.getTokenValue());
        return SaResult.data(StpUtil.getTokenValue());
    }

    @Log
    @Operation(description = "获取用户")
    @GetMapping("/get/{id}")
    public RestResponse<SysUser> getById(@PathVariable("id") Long id) {
        return RestResponse.success(Optional.ofNullable(id)
                .map(t -> sysUserService.getById(t)).orElse(null));
    }

    @Operation(description = "用户批量删除")
    @DeleteMapping("/del")
    public RestResponse<Boolean> delUserByIds(@RequestParam List<Long> ids) {
        return RestResponse.success(Optional.ofNullable(ids).map(t -> sysUserService.delUserByIds(t)).orElse(false));
    }

    @Log
    @Operation(description = "用户导出")
    @PostMapping("/export")
    public void export(@RequestBody SystemUserQueryRequest request) {
        Optional.ofNullable(request).ifPresent(t -> {
            sysUserService.export(t);
        });
    }

    @Operation(description = "保存个人中心信息")
    @PostMapping("/personalCenterSave")
    public RestResponse<SysUser> personalCenterSave(@RequestBody SysUser sysUser) {
        return RestResponse.success(sysUserService.personalCenterSave(sysUser));
    }

    @Operation(description = "获取个人中心详情")
    @GetMapping("/getPersonalCenterDetail")
    public RestResponse<SysUser> getPersonalCenterDetail() {
        return RestResponse.success(sysUserService.getById((Long) StpUtil.getLoginId()));
    }

    @Operation(description = "切换用户字段值")
    @PostMapping("/switch_prop")
    public RestResponse<PageResult<SysUser>> switchMenuProp(@RequestBody UserSwitchMenuPropRequest param) {
        sysUserService.switchMenuProp(param);
        return RestResponse.success();
    }

    @Operation(description = "用户批量导入")
    @PostMapping("/imports")
    public RestResponse<ArrayList<Map<String, Object>>> imports(@RequestBody List<SysUser> sysUsers) {
        return RestResponse.success(sysUserService.imports(sysUsers));
    }

    @Operation(description = "用户账号密码重置")
    @PostMapping("/resetPassword")
    public RestResponse<ArrayList<Map<String, Object>>> resetPassword(@RequestBody SysUser sysUsers) {
        sysUserService.resetPassword(sysUsers);
        return RestResponse.success();
    }

    @Operation(description = "系统用户组查询")
    @PostMapping("/queryUserGroupList")
    public RestResponse<PageResult<SysUserGroup>> queryUserGroupList(@RequestBody PageQuery<UserQueryUserGroupListRequest> pageQuery) {
        return RestResponse.success(Optional.ofNullable(pageQuery).map(sysUserService::queryUserGroupList).orElse(null));
    }

    @Operation(description = "用户组保存")
    @PostMapping("/saveUserGroup")
    public RestResponse<SysUserGroup> saveUserGroup(@RequestBody SysUserGroup sysUserGroup) {
        return RestResponse.success(sysUserService.saveUserGroup(sysUserGroup));
    }

    @Operation(description = "id获取用户组详情")
    @GetMapping("/getUserGroup/{id}")
    public RestResponse<SysUserGroup> getUserGroupById(@PathVariable Integer id) {
        return RestResponse.success(sysUserService.getUserGroupById(id));
    }

    @Operation(description = "ids批量删除用户组")
    @DeleteMapping("/delUserGroup")
    public RestResponse<?> delUserGroup(@RequestParam List<Integer> ids) {
        sysUserService.delUserGroup(ids);
        return RestResponse.success();
    }

    @Operation(description = "获取用户或者用户组的岗位信息")
    @GetMapping("/getUserJobs")
    public RestResponse<List<SysUserJob>> getUserJobs(SysUserJob param) {
        return RestResponse.success(sysUserService.getUserJobs(param));
    }

    @Operation(description = "用户岗位保存")
    @PostMapping("/saveUserJobs")
    public RestResponse<?> saveUserJobs(@RequestBody SysUserJobDTO sysUserJobDTO) {
        sysUserService.saveUserJobs(sysUserJobDTO);
        return RestResponse.success();
    }

    @Operation(description = "id获取用户所在的所有用户组信息")
    @GetMapping("/getUserGroups/{id}")
    public RestResponse<List<SysUserGroup>> getUserGroups(@PathVariable Integer id) {
        return RestResponse.success(sysUserService.getUserGroups(id));
    }

    @Operation(description = "在线用户查询")
    @PostMapping("/queryOnlineUser")
    public RestResponse<PageResult<OnlineUserDTO>> queryOnlineUser(@RequestBody PageQuery<Map<String, Object>> pageQuery) {
        PageResult<OnlineUserDTO> data = sysLoginService.queryOnlineUser(pageQuery);
        return RestResponse.success(data);
    }

    @Operation(description = "踢用户下线")
    @PostMapping("/kickOut")
    public RestResponse<?> kickOut(@RequestBody String token) {
        sysLoginService.kickOut(token);
        return RestResponse.success();
    }

    @Operation(description = "用户角色排序")
    @PostMapping("/roleSort")
    public RestResponse<?> roleSort(@RequestBody String roleSorter) {
        sysLoginService.roleSort(roleSorter);
        return RestResponse.success();
    }

}
