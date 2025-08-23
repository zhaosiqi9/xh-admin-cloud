package com.xh.system.domain.constant.sysuser;

import lombok.Data;
import lombok.Getter;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 09:13
 */
@Data
public class SysUserConstant {


    @Getter
    public enum SysUserRootType {
        DEFAULT("default", "默认-只有用户信息"),
        ROLE("role", "用户+角色信息"),
        ORG("job", "用户+部门信息"),
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
