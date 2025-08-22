package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统用户组成员")
@TableName("sys_user_group_member")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserGroupMember extends BaseEntity {

    @Schema(title = "系统用户组id")
    private Integer sysUserGroupId;

    @Schema(title = "系统用户id")
    private Integer sysUserId;

    @Schema(title = "用户账号")
    @TableField(exist = false)
    private String userCode;

    @Schema(title = "用户名称")
    @TableField(exist = false)
    private String userName;
}
