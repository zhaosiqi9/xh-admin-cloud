package com.xh.jwt.dto;

import cn.hutool.core.collection.CollUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用于承载用户登录信息
 *
 * @author sunxh 2023/3/1
 */
@Schema(description = "用于承载用户登录信息，存入session中")
@Data
public class SysLoginUserInfoDTO implements Serializable {

    @Schema(title = "当前登录的用户信息")
    private SysUserDTO user;

    @Schema(title = "当前用户拥有的角色")
    private List<SysOrgRoleDTO> roles = CollUtil.newArrayList();
}
