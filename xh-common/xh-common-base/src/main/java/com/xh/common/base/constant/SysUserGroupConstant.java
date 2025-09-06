package com.xh.common.base.constant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
@Schema(title = "用户常量")
public class SysUserGroupConstant {
    
    @Getter
    public enum UserGroupMemberRootType {
        DEFAULT("default", "默认-只有用户信息"),
        MEMBER("member", "用户组-用户组信息"),
        ;

        private final String type;

        private final String description;

        UserGroupMemberRootType(String type, String description) {
            this.type = type;
            this.description = description;
        }

    }
}
