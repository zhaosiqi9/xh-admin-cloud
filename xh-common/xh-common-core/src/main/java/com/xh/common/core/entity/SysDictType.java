package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@TableName("sys_dict_type")
@Data
@Schema(title = "数据字典类型")
@EqualsAndHashCode(callSuper = true)
public class SysDictType extends BaseEntity {

    @Schema(title = "字典类型名称")
    private String name;

    @Schema(title = "是否可修改")
    private Boolean modifiable;
}
