package com.xh.common.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 08:36
 */
public class CommonUtil {

    public static String camelToSnake(String camelCase) {
         if (camelCase == null || camelCase.isEmpty()) {
            return camelCase;
        }
        // 先将驼峰转成带分隔符的形式，再替换分隔符为下划线并转小写
        return StringUtils.join(
            StringUtils.splitByCharacterTypeCamelCase(camelCase), 
            "_"
        ).toLowerCase();
    }
}
