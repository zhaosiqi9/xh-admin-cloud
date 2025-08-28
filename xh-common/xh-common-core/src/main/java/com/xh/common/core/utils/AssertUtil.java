package com.xh.common.core.utils;

import com.xh.common.core.web.MyException;

public class AssertUtil {
    
    public static void notBlank(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new MyException(message);
        }
    }
}
