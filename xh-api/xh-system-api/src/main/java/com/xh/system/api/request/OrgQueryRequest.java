package com.xh.system.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "组织查询参数")
public class OrgQueryRequest {
    
    @Schema(title = "主键ID")
    private Long id;

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
