package com.xh.system.application.service.dto;

import com.xh.jwt.dto.SysMenuDTO;
import com.xh.jwt.dto.SysOrgRoleDTO;
import com.xh.jwt.dto.SysUserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/31 10:32
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
