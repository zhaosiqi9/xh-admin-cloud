package com.xh.system.application.command.sysuser;

import com.xh.system.domain.constant.sysuser.SysUserConstant;
import lombok.Data;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 09:40
 */
@Data
public class GetUserInfoCommand {

    private Long userId;

    private String userName;

    private boolean enabled = true;

    private SysUserConstant.SysUserRootType type;
}
