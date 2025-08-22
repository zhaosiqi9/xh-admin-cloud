package com.xh.common.core.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : gr
 * @version 1.0.0
 * @date : 2025/8/22 12:10
 */
@Data
public class DataPermissionEntity extends BaseEntity implements Serializable {

    @Schema(title = "机构ID")
    protected Integer sysOrgId;

    @Schema(title = "角色ID")
    protected Integer sysRoleId;
}