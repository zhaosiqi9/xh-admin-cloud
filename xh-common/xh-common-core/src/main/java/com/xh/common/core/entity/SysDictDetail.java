package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@TableName("sys_dict_detail")
@Data
@Schema(title = "数据字典明细")
@EqualsAndHashCode(callSuper = true)
public class SysDictDetail extends BaseEntity {
    @Schema(title = "字典类型ID")
    private Integer sysDictTypeId;

    @Schema(title = "上级id")
    private Integer parentId;

    @Schema(title = "字典值key")
    private String value;

    @Schema(title = "字典名称")
    private String label;

    @Schema(title = "排序号")
    private Integer order;

    @Schema(title = "是否启用")
    private Boolean enabled;

    @Schema(title = "数据字典类型ID")
    @TableField(exist = false)
    private String dictTypeId;

    @Schema(title = "数据自定类型名称")
    @TableField(exist = false)
    private String dictTypeName;
}
