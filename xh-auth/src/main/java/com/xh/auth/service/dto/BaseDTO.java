package com.xh.auth.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础DTO
 *
 * @author sunxh 2023/3/1
 */
@Data
public class BaseDTO<I> implements Serializable {
    @Schema(title = "主键ID")
    protected I id;
    @Schema(title = "创建时间")
    private LocalDateTime createTime;
    @Schema(title = "修改时间")
    private LocalDateTime updateTime;
    @Schema(title = "创建人")
    private Integer createBy;
    @Schema(title = "修改人")
    private Integer updateBy;
}
