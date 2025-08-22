package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统角色权限表")
@TableName("sys_role_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends BaseEntity {
    @Schema(title = "角色id")
    private Integer sysRoleId;

    @Schema(title = "菜单id")
    private Integer sysMenuId;
}
