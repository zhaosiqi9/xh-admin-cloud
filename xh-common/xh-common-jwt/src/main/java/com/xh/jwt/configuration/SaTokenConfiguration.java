package com.xh.jwt.configuration;

import cn.dev33.satoken.jwt.SaJwtTemplate;
import cn.dev33.satoken.jwt.SaJwtUtil;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import cn.hutool.jwt.JWT;
import com.xh.common.core.factory.YmlPropertySourceFactory;
import com.xh.jwt.service.StpInterfaceImpl;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Sa-Token 配置
 *
 * @author Lion Li
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-satoken.yml", factory = YmlPropertySourceFactory.class)
@Slf4j
public class SaTokenConfiguration {

    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }
    
    /**
     * 权限接口实现
     */
    @Bean
    public StpInterface stpInterface() {
        return new StpInterfaceImpl();
    }


    /**
     * 自定义 SaJwtUtil 生成 token 的算法
     */
    @PostConstruct
    public void setSaJwtTemplate() {
        SaJwtUtil.setSaJwtTemplate(new SaJwtTemplate() {
            @Override
            public String generateToken(JWT jwt, String keyt) {
                log.debug("------ 自定义了 token 生成算法");
                // 这里实现自定义的token生成逻辑
                // 例如使用不同的加密算法或添加额外的安全措施
                // 可以使用Hutool的JWT工具或其他加密库

                // 示例：使用 HmacSHA256 SHA256算法签名
                return jwt.setSigner("HmacSHA256", keyt.getBytes()).sign();
//                return super.generateToken(jwt, keyt);
            }
        });
    }

}