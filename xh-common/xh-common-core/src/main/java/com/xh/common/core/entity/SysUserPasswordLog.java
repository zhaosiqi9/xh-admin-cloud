package com.xh.common.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Schema(title = "系统用户密码修改日志")
@TableName("sys_user_password_log")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserPasswordLog extends BaseEntity {
    @Schema(title = "系统用户id")
    private Integer sysUserId;

    @Schema(title = "原密码")
    private String oldPassword;

    @Schema(title = "新密码")
    private String newPassword;
}
