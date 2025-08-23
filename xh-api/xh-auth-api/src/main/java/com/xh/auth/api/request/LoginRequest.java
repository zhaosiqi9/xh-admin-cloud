// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.xh.auth.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "登录请求")
public class LoginRequest {
    @Schema(title = "密码")
    private String password;

    @Schema(title = "用户名")
    private String captchaCode;

    @Schema(title = "验证码")
    private String captchaKey;

    @Schema(title = "语言")
    private String localeLabel;

    @Schema(title = "是否演示账号")
    private boolean isDemo;

    @Schema(title = "语言")
    private String locale;

    @Schema(title = "用户名")
    private String username;

    @Schema(title = "用户代理")
    private String userAgent;
}
