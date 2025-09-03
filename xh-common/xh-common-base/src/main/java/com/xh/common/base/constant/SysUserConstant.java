package com.xh.common.base.constant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
@Schema(title = "用户常量")
public class SysUserConstant {

    @Getter
    public enum SysUserRootType {
        DEFAULT("default", "默认-只有用户信息"),
        ROLE("role", "用户+角色信息"),
        ORG("org", "用户+部门信息"),
        ORG_ROLE("org_role", "用户+部门+角色信息"),
        ;

        private final String type;

        private final String description;

        SysUserRootType(String type, String description) {
            this.type = type;
            this.description = description;
        }

    }
}