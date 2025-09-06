package com.xh.system.domain.entity;

import com.xh.common.core.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(title = "系统用户组成员")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserGroupMember extends BaseEntity {

    @Schema(title = "系统用户组id")
    private Integer sysUserGroupId;
    
    @Schema(title = "系统用户id")
    private Integer sysUserId;

    @Schema(title = "用户账号")
    private String userCode;
    
    @Schema(title = "用户名称")
    private String userName;

}
