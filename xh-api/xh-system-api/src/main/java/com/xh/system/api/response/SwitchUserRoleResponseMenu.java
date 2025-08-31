package com.xh.system.api.response;

import com.xh.common.base.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "切换用户角色返回菜单")
public class SwitchUserRoleResponseMenu extends BaseEntity {

    @Schema(title = "角色id")
    private Integer roleId;

    @Schema(title = "上级id")
    private Integer parentId;

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
