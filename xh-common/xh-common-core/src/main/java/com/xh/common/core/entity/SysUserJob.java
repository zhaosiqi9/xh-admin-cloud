package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统用户岗位表")
@TableName("sys_user_job")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserJob extends BaseEntity {

    @Schema(title = "数据类型", allowableValues = {"1", "2"}, description = "1：用户，2：用户组")
    private Integer type;
    
    @Schema(title = "用户id或者用户组的id")
    private Integer userId;
    
    @Schema(title = "机构id")
    private Integer sysOrgId;
    
    @Schema(title = "角色id")
    private Integer sysRoleId;
    
    @Schema(title = "是否启用1：是，0：否")
    private Boolean enabled;

    @Schema(title = "机构代码")
    @TableField(exist = false)
    private String orgCode;
    
    @Schema(title = "机构名称")
    @TableField(exist = false)
    private String orgName;
    
    @Schema(title = "角色名称")
    @TableField(exist = false)
    private String roleName;
}
