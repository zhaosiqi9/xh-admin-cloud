// SystemUserQueryRequest.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.xh.system.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "系统用户查询参数")
public class SystemUserQueryRequest {

    @Schema(description = "参数")
    private SystemUserQueryRequestParam param;

    @Schema(description = "是否导出")
    private Boolean isExport;

    @Schema(description = "每页数量")
    private long pageSize = 10;

    @Schema(description = "高级筛选")
    private List<AdvanceFilter> filters;

    @Schema(description = "当前页")
    private long currentPage = 1;

    @Schema(description = "是否分页")
    private boolean isPage = true;
}


@Data
@Schema(description = "高级筛选")
class AdvanceFilter {
    @Schema(description = "条件")
    private String condition;

    @Schema(description = "值2")
    private String value2;

    @Schema(description = "值1")
    private String value1;

    @Schema(description = "子列表")
    private List<Object> children;

    @Schema(description = "属性")
    private String prop;

    @Schema(description = "是否选中")
    private Boolean checked;

    @Schema(description = "逻辑")
    private String logic;
}
