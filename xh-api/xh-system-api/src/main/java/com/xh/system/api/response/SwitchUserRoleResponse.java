package com.xh.system.api.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "切换用户角色返回")
public class SwitchUserRoleResponse {

    @Schema(description = "角色列表")
    private List<SwitchUserRoleResponseRole> roles;

    @Schema(description = "token名称")
    private String tokenName;

    @Schema(description = "菜单列表")
    private List<SwitchUserRoleResponseMenu> menus;

    @Schema(description = "token值")
    private String tokenValue;

    @Schema(description = "用户信息")
    private SwitchUserRoleResponseUser user;
}
