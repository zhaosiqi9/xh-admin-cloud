package com.xh.system.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 23:07
 */
@Data
public class GetUserInfoResponseJob {

    @Schema(title = "主键ID")
    protected Long id;

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
    private String orgCode;

    @Schema(title = "机构名称")
    private String orgName;

    @Schema(title = "角色名称")
    private String roleName;


    @Schema(title = "创建时间")
    private LocalDateTime createTime;

    @Schema(title = "修改时间")
    private LocalDateTime updateTime;

    @Schema(title = "创建人")
    private Integer createBy;

    @Schema(title = "修改人")
    private Integer updateBy;

    @Schema(title = "是否已删除")
    private Boolean deleted;
}
