package com.xh.common.core.constants;

import lombok.Getter;

@Getter
public enum SystemRedisConstant {

    /**
     * 验证码 redis 前缀
     */
    CAPTCHA_KEY_PREFIX("captcha:", "验证码 redis 前缀"),

    /**
     * 角色权限集合 redis 前缀
     */
    ROLE_PERMISSIONS_PREFIX("role:permissions:", "角色权限集合 redis 前缀");

    private final String value;

    private final String desc;

    SystemRedisConstant(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
