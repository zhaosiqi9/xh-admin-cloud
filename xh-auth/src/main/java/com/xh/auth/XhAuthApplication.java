package com.xh.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.xh"})
public class XhAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XhAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  xh-auth启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }

}
