package com.xh.system.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 23:08
 */
@Data
public class GetUserInfoResponseOrg {

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
