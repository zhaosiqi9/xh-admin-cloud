package com.xh.common.core.annotation;

import com.xh.common.base.constant.BusinessType;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    
    String value() default "";
    
    String title();
    
    BusinessType businessType();
    
}
