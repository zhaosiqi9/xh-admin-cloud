package com.xh.common.core.utils;

import cn.hutool.core.collection.CollUtil;
import com.xh.common.base.exception.MyException;

import java.util.Collection;
import java.util.List;
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

    public static<E> void isNotEmpty(Collection<E> collection, String message) {
        if (CollUtil.isEmpty(collection)) {
            throw new MyException(message);
        }
    }
}
