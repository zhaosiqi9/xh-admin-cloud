package com.xh.system.api.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/26 11:17
 */
@Data
@Schema(description = "基础实体")
public class ApiBaseEntity implements Serializable {
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
}
