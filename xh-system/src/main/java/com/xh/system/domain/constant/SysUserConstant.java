package com.xh.system.domain.constant;

import lombok.Getter;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 17:39
 */
@Getter
public enum SysUserConstant {
    DEFAULT("0", "默认构造");
    private final String value;
    private final String message;

    SysUserConstant(String value, String message) {
        this.value = value;
        this.message = message;
    }
}
