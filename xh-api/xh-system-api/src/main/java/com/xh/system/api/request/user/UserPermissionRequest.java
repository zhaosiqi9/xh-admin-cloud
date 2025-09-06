package com.xh.system.api.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户权限请求")
public class UserPermissionRequest {

    @Schema(title = "角色id")
    private Long roleId;

    @Schema(title = "是否刷新")
    private boolean refresh = false;


    @Schema(title = "初始化请求")
    public static UserPermissionRequest initRequest(Long roleId) {
        return initRequest(roleId, false);
    }

    @Schema(title = "初始化请求")
    public static UserPermissionRequest initRequest(Long roleId, boolean refresh) {
        UserPermissionRequest request = new UserPermissionRequest();
        request.setRoleId(roleId);
        request.setRefresh(refresh);
        return request;
    }
}
