package com.xh.system.api.constant.sysuser;

import lombok.Data;
import lombok.Getter;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 09:34
 */
@Data
public class SysUserConstant {

    @Getter
    public enum GetUpdateUserInfoType {
        DEFAULT("default", "默认"),
        ROLE("role", "角色"),
        ;
        private final String type;
        private final String description;
        GetUpdateUserInfoType(String type, String description) {
            this.type = type;
            this.description = description;
        }
        
    }
}
