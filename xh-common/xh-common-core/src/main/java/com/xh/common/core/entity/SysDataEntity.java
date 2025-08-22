package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(title = "系统数据实体")
@TableName
@Data
public class SysDataEntity {

    @Schema(title = "主键ID")
    @TableId
    private String id;

    @Schema(title = "数据实体名称")
    private String name;
}
