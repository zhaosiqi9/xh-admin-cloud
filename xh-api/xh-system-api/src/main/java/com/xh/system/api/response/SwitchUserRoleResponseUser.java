package com.xh.system.api.response;

import com.xh.system.api.base.ApiBaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "切换用户角色返回用户信息")
public class SwitchUserRoleResponseUser extends ApiBaseEntity {

    @Schema(title = "用户代码")
    private String code;

    @Schema(title = "用户名")
    private String name;

    @Schema(title = "头像")
    private String avatar;

    @Schema(title = "手机号码")
    private String telephone;

    @Schema(title = "允许重复登录")
    private Boolean allowRepeat;

    @Schema(title = "自动续签，请求会自动延长token失效时间")
    private Boolean autoRenewal;

    @Schema(title = "是否启用")
    private Boolean enabled;

    @Schema(title = "是否演示账号")
    private Boolean isDemo;
}
