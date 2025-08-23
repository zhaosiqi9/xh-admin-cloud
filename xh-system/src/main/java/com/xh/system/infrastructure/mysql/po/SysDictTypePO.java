package com.xh.system.infrastructure.mysql.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@TableName("sys_dict_type")
@Data
@Schema(title = "数据字典类型")
@EqualsAndHashCode(callSuper = true)
public class SysDictTypePO extends BaseEntity {

    @Schema(title = "字典类型名称")
    private String name;

    @Schema(title = "是否可修改")
    private Boolean modifiable;
}
