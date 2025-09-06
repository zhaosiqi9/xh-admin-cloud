package com.xh.system.domain.entity;

import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(title = "系统用户组")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserGroup extends BaseEntity {

    @Schema(title = "用户组名")
    private String name;
    
    @Schema(title = "是否启用")
    private Boolean enabled;

    @Schema(title = "岗位信息")
    private List<SysUserJob> jobData;
    
    @Schema(title = "用户组成员")
    private List<SysUserGroupMember> memberData;
}
