package com.xh.auth.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 角色权限集合持久化对象
 *
 * @author sunxh 2023/3/1
 */
@Data
public class RolePermissionsDTO implements Serializable {
    @Schema(title = "角色ID")
    protected Long roleId;
    @Schema(title = "创建时间")
    private LocalDateTime createTime;
    @Schema(title = "修改时间")
    private LocalDateTime updateTime;
    @Schema(title = "角色拥有的权限")
    private List<SysMenuDTO> permissions;
}