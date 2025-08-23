package com.xh.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 22:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserJob extends BaseEntity {

    @Schema(title = "数据类型", allowableValues = {"1", "2"}, description = "1：用户，2：用户组")
    private Integer type;

    @Schema(title = "用户id或者用户组的id")
    private Long userId;

    @Schema(title = "机构id")
    private Long sysOrgId;

    @Schema(title = "角色id")
    private Long sysRoleId;

    @Schema(title = "是否启用1：是，0：否")
    private Boolean enabled;

    @Schema(title = "机构代码")
    @TableField(exist = false)
    private String orgCode;

    @Schema(title = "机构名称")
    @TableField(exist = false)
    private String orgName;

    @Schema(title = "角色名称")
    @TableField(exist = false)
    private String roleName;
}
