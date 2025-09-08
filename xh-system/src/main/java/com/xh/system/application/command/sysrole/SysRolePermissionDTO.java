package com.xh.system.application.command.sysrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(title = "系统数据权限")
@Data
public class SysRolePermissionDTO {
    @Schema(title = "权限ID")
    private Long sysRoleId;

    @Schema(title = "角色数据权限")
    List<SysRoleDataPermission> permissions;
}
