package com.xh.system.api.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统用户组查询")
public class UserQueryUserGroupListRequest {
    @Schema(description = "用户组id")
    private String code;

    @Schema(description = "用户组名称")
    private String name;
}
