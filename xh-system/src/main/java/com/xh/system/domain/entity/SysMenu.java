package com.xh.system.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:11
 */
@Data
public class SysMenu {

    @Schema(title = "主键ID")
    protected Long id;

    @Schema(title = "创建时间")
    private LocalDateTime createTime;

    @Schema(title = "修改时间")
    private LocalDateTime updateTime;

    @Schema(title = "创建人")
    private Integer createBy;

    @Schema(title = "修改人")
    private Integer updateBy;

    @Schema(title = "是否已删除")
    private Boolean deleted;

    @Schema(title = "上级id")
    private Long parentId;

    @Schema(title = "菜单标题")
    private String title;

    @Schema(title = "路由名称")
    private String name;

    @Schema(title = "路由路径")
    private String path;

    @Schema(title = "组件全路径")
    private String component;

    @Schema(title = "平台", allowableValues = {"web", "app"})
    private String platform;

    @Schema(title = "菜单类型", allowableValues = {"dir", "menu", "btn"}, description = "目录，menu：菜单，btn：按钮")
    private String type;

    @Schema(title = "处理类型", allowableValues = {"route", "iframe", "outer"}, description = "路由：route，iframe：iframe，outer：外链")
    private String handleType;

    @Schema(title = "外链地址")
    private String outerUrl;

    @Schema(title = "菜单图标")
    private String icon;

    @Schema(title = "排序号")
    private Integer order;

    @Schema(title = "是否缓存")
    private Boolean cache;

    @Schema(title = "是否启用")
    private Boolean enabled;
}
