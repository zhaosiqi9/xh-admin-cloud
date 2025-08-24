package com.xh.system.infrastructure.mysql.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统机构")
@TableName("sys_org")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysOrgPO extends BaseEntity {

    @Schema(title = "机构代码")
    private String code;

    @Schema(title = "机构名称")
    private String name;

    @Schema(title = "上级机构")
    private String parentId;

    @Schema(title = "启用状态")
    private Boolean enabled;
}
