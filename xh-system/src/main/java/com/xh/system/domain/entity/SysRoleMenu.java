package com.xh.system.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:43
 */
@Data
public class SysRoleMenu {
    @Schema(title = "主键ID")
    protected Long id;

    @Schema(title = "角色id")
    private Long sysRoleId;

    @Schema(title = "菜单id")
    private Long sysMenuId;

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
}
