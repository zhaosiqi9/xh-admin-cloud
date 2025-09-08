package com.xh.system.application.command.sysrole;

import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(title = "系统角色数据权限")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleDataPermission extends BaseEntity {

    @Schema(title = "角色ID")
    private Long sysRoleId;

    @Schema(title = "数据实体ID")
    private Long sysDataEntityId;

    @Schema(title = "数据权限ID")
    private Long sysDataPermissionId;
}
