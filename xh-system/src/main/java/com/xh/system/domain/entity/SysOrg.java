package com.xh.system.domain.entity;

import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 22:26
 */
@Data
public class SysOrg extends BaseEntity {
    @Schema(title = "机构代码")
    private String code;

    @Schema(title = "机构名称")
    private String name;

    @Schema(title = "上级机构")
    private String parentId;

    @Schema(title = "启用状态")
    private Boolean enabled;

    @Schema(title = "上级机构名称")
    private String parentName;
}
