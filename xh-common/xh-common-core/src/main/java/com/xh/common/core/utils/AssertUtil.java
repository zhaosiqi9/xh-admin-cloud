package com.xh.common.core.utils;

import com.xh.common.base.exception.MyException;

import java.util.Objects;

public class AssertUtil {
    
    public static void notBlank(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new MyException(message);
        }
    }

    public static void equals(Object value1, Object value2, String message) {
        if (!Objects.equals(value1, value2)) {
            throw new MyException(message);
        }
    }
}
