package com.xh.system.domain.constant.sysmenu;

import lombok.Data;
import lombok.Getter;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:25
 */
@Data
public class SysMenuConstant {

    @Getter
    public enum SysMenuRootType {
        DEFAULT("default", "默认-只有菜单信息"),
        ;

        private final String type;

        private final String description;

        SysMenuRootType(String type, String description) {
            this.type = type;
            this.description = description;
        }
    }
}
