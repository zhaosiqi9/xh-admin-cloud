package com.xh.auth.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 岗位信息DTO
 *
 * @author sunxh 2023/3/1
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SysOrgRoleDTO extends BaseDTO<Long> {
    @Schema(title = "数据类型", allowableValues = {"1", "2"}, description = "1：用户，2：用户组")
    private Integer type;

    @Schema(title = "用户id或者用户组的id")
    private Long userId;

    @Schema(title = "机构id")
    private Long sysOrgId;

    @Schema(title = "角色id")
    private Long sysRoleId;

    @Schema(title = "机构代码")
    private String orgCode;

    @Schema(title = "机构名称")
    private String orgName;

    @Schema(title = "角色名称")
    private String roleName;

    @Schema(title = "是否当前使用的角色")
    private Boolean active;
}