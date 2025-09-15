package com.xh.common.base.constant;

/**
 * @author : gr
 * @version 1.0.0
 * @date : 2025/9/15 16:46
 */
public enum BusinessType {
    /**
     * 其它
     */
    OTHER,
    /**
     * 新增
     */
    INSERT,
    /**
     * 修改
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 授权
     */
    GRANT,
    /**
     * 导出
     */
    EXPORT,
    /**
     * 导入
     */
    IMPORT,
    /**
     * 强退
     */
    FORCE;
    private final String value;
    BusinessType() {
        this.value = name();
    }
}
