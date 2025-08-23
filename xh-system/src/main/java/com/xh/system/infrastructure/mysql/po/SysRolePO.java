package com.xh.system.infrastructure.mysql.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Schema(title = "系统角色")
@TableName("sys_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRolePO extends BaseEntity {

    @Schema(title = "角色具有的权限")
    @TableField(exist = false)
    List<SysRoleMenuPO> roleMenus;

    @Schema(title = "角色名称")
    private String name;

    @Schema(title = "上级角色")
    private Integer parentId;

    @Schema(title = "启用状态")
    private Boolean enabled;

    @Schema(title = "上级角色名称")
    @TableField(exist = false)
    private String parentName;
}
