package com.xh.system.api.response;

import com.xh.common.base.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "切换用户角色返回角色")
public class SwitchUserRoleResponseRole extends BaseEntity {

    @Schema(title = "数据类型", allowableValues = {"1", "2"}, description = "1：用户，2：用户组")
    private Integer type;

    @Schema(title = "用户id或者用户组的id")
    private Integer userId;

    @Schema(title = "机构id")
    private Integer sysOrgId;

    @Schema(title = "角色id")
    private Integer sysRoleId;

    @Schema(title = "机构代码")
    private String orgCode;

    @Schema(title = "机构名称")
    private String orgName;

    @Schema(title = "角色名称")
    private String roleName;

    @Schema(title = "是否当前使用的角色")
    private Boolean active;
}
