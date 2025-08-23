package com.xh.auth.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 用于承载用户登录信息
 *
 * @author sunxh 2023/3/1
 */
@Schema(description = "用于承载用户登录信息")
@Data
public class LoginUserInfoVO {

    @Schema(title = "tokenName")
    private String tokenName;
    @Schema(title = "tokenValue")
    private String tokenValue;
    @Schema(title = "当前登录的用户信息")
    private SysUserDTO user;
    @Schema(title = "当前用户角色拥有的菜单权限")
    private List<SysMenuDTO> menus;
    @Schema(title = "当前用户角色拥有的角色")
    private List<SysOrgRoleDTO> roles;
}
