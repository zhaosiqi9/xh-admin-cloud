package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(title = "系统机构")
@TableName("sys_org")
@Data
public class SysOrg {

    @Schema(title = "机构代码")
    private String code;
    
    @Schema(title = "机构名称")
    private String name;
    
    @Schema(title = "上级机构")
    private String parentId;
    
    @Schema(title = "启用状态")
    private Boolean enabled;
    
    @Schema(title = "上级机构名称")
    @TableField(exist = false)
    private String parentName;
}
