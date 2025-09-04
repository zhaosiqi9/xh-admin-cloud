package com.xh.system.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统角色查询参数")
public class RoleQueryRequest {

    @Schema(title = "主键ID")
    private Long id;

    @Schema(title = "用户代码")
    private String code;

    @Schema(title = "用户名")
    private String name;

    @Schema(title = "密码")
    private String password;

    @Schema(title = "头像")
    private String avatar;

    @Schema(title = "手机号码")
    private String telephone;

    @Schema(title = "状态（1：正常，2：锁定）")
    private Integer status;

    @Schema(title = "登录失败的次数")
    private Integer failuresNum;

    @Schema(title = "账号锁定的原因")
    private String lockMsg;

    @Schema(title = "允许重复登录")
    private Boolean allowRepeat;

    @Schema(title = "自动续签，请求会自动延长token失效时间")
    private Boolean autoRenewal;

    @Schema(title = "是否演示账号")
    private Boolean isDemo;

    @Schema(title = "角色排序")
    private String roleSorter;
}
