package com.xh.system.infrastructure.mysql.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(title = "系统数据实体")
@TableName("sys_data_entity")
@Data
public class SysDataEntityPO {

    @Schema(title = "主键ID")
    @TableId
    private String id;

    @Schema(title = "数据实体名称")
    private String name;
}
