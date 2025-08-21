package com.alibaba.nacos;

import com.alibaba.nacos.sys.filter.NacosTypeExcludeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Nacos starter.
 * <p>
 * Use @SpringBootApplication and @ComponentScan at the same time, using CUSTOM type filter to control module enabled.
 * </p>
 *
 * @author nacos
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.alibaba.nacos", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {NacosTypeExcludeFilter.class}),
    @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {TypeExcludeFilter.class}),
    @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {AutoConfigurationExcludeFilter.class})})
@ServletComponentScan
public class Nacos {

    public static void main(String[] args) {
        // true 单机模式 false 为集群模式 集群模式需搭配 cluster.conf 使用 使用方法请查看文档
        System.setProperty("nacos.standalone", "true");
        System.setProperty("server.tomcat.accesslog.enabled", "false");
        // 本地集群搭建使用 分别在所有 nacos 目录下创建 conf/cluster.conf 文件用于编写集群ip端口
        // 注意 如果本地启动多个 nacos 此目录不能相同 例如 nacos1 nacos2 nacos3 对应三个nacos服务
        // System.setProperty("nacos.home", "D:/nacos");
        SpringApplication.run(Nacos.class, args);
    }
}
