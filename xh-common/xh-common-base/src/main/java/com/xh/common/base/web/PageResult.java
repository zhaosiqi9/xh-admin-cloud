package com.xh.common.base.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果
 * sunxh
 * 2023-02-25
 */
@Setter
@Getter
@NoArgsConstructor
@Schema(title = "分页结果")
public class PageResult<T> implements Serializable {
    @Schema(title = "列表数据")
    private List<T> list = new ArrayList<>();

    @Schema(title = "总数")
    private Integer total = 0;

    @Schema(title = "是否分页")
    private Boolean isPage = true;

    @Schema(title = "分页号")
    private Integer currentPage;

    @Schema(title = "分页大小")
    private Integer pageSize;

    public PageResult(List<T> list, Integer total) {
        this.list = list;
        this.total = total;
    }
}