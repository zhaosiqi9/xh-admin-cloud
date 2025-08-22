package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统角色数据权限")
@TableName("sys_role_data_permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleDataPermission extends BaseEntity {

    @Schema(title = "角色ID")
    private Integer sysRoleId;

    @Schema(title = "数据实体ID")
    private String sysDataEntityId;

    @Schema(title = "数据权限ID")
    private Integer sysDataPermissionId;
}
