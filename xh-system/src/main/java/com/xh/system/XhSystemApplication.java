package com.xh.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.xh"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xh"})
@MapperScan(basePackages = {"com.xh.**.mapper"})
public class XhSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(XhSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  xh-system启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }

}
