package com.xh.system.api.request;

import com.xh.system.api.constant.sysuser.SysUserConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 23:54
 */
@Data
@Accessors(chain = true)
@Schema(description = "获取用户信息请求参数")
public class GetUserInfoRequest {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "用户是否启用")
    private boolean enabled = true;

    @Schema(description = "获取用户信息类型")
    private SysUserConstant.GetUpdateUserInfoType type;
}
