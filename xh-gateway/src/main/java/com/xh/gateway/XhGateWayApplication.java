package com.xh.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {cn.dev33.satoken.spring.SaTokenContextRegister.class})
public class XhGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(XhGateWayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  xh-gateway启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
