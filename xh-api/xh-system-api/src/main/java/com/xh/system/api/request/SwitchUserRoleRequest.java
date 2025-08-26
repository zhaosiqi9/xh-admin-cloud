package com.xh.system.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "角色切换参数")
@Data
public class SwitchUserRoleRequest {

    @Schema(description = "用户id")
    private String orgName;

    @Schema(description = "是否激活")
    private Boolean active;

    @Schema(description = "角色id")
    private Long sysRoleId;

    @Schema(description = "组织名称")
    private String orgCode;

    @Schema(description = "组织id")
    private Long sysOrgId;

    @Schema(description = "角色名称")
    private String roleName;
}
