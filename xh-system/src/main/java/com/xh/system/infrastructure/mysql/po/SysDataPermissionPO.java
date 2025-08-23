package com.xh.system.infrastructure.mysql.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统数据权限")
@TableName("sys_data_permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDataPermissionPO extends BaseEntity {
    @Schema(title = "数据权限名称")
    private String name;

    @Schema(title = "权限表达式")
    private String expression;

    @Schema(title = "权限json数据")
    private String json;
}
