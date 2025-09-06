package com.xh.system.interfaces;

import com.xh.common.base.web.RestResponse;
import com.xh.common.core.annotation.Log;
import com.xh.system.api.contract.RemoteSysMenuContract;
import com.xh.system.api.request.user.UserPermissionRequest;
import com.xh.system.api.response.UserPermissionResponse;
import com.xh.system.application.service.SysMenuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}
