package com.xh.common.core.utils;

import com.xh.common.base.exception.MyException;

public class AssertUtil {
    
    public static void notBlank(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new MyException(message);
        }
    }
}
