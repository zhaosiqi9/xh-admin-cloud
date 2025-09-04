package com.xh.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusHandler implements MetaObjectHandler {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MybatisPlusHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        setFieldValByName("createTime", java.time.LocalDateTime.now(), metaObject);
//        setFieldValByName("createBy", StpUtil.getLoginId(), metaObject);
        setFieldValByName("updateTime", java.time.LocalDateTime.now(), metaObject);
//        setFieldValByName("updateBy", StpUtil.getLoginId(), metaObject);
        setFieldValByName("deleted", false, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        setFieldValByName("updateTime", java.time.LocalDateTime.now(), metaObject);
//        setFieldValByName("updateBy", StpUtil.getLoginId(), metaObject);

    }
}
