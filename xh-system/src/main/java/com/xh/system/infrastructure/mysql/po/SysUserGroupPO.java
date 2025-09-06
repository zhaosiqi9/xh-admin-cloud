package com.xh.system.infrastructure.mysql.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Schema(title = "系统用户组")
@TableName("sys_user_group")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserGroupPO extends BaseEntity {

    @Schema(title = "用户组名")
    private String name;
    
    @Schema(title = "是否启用")
    private Boolean enabled;

    @Schema(title = "岗位信息")
    @TableField(exist = false)
    private List<SysUserJobPO> jobData;

    @Schema(title = "用户组成员")
    @TableField(exist = false)
    private List<SysUserGroupMemberPO> memberData;
}
