package com.xh.common.core.configure;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 09:18
 */
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        System.out.println("JacksonConfig");
        return builder -> {
            // 注册Java 8时间模块
            JavaTimeModule javaTimeModule = new JavaTimeModule();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));


            javaTimeModule.addSerializer(Long.class, CustomerJacksonSerializer.instance);
            javaTimeModule.addSerializer(Long.TYPE, CustomerJacksonSerializer.instance);
            javaTimeModule.addSerializer(BigInteger.class, CustomerJacksonSerializer.instance);
            javaTimeModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);

            // 添加LocalDateTime反序列化器
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));

            // 全局配置序列化特性
            builder.featuresToDisable(
                    SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                    SerializationFeature.FAIL_ON_EMPTY_BEANS
            );

            // 反序列化配置
            builder.featuresToEnable(
                    com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT
            );

            // 设置默认视图等其他配置
            // builder.defaultView(Views.Public.class);

            builder.modules(javaTimeModule);
        };
    }
}
