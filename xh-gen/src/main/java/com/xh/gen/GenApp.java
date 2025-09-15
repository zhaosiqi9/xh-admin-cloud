package com.xh.gen;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @date : 2025/9/15 10:20
 */
public class GenApp {

    private static final String url = "jdbc:mysql://localhost:3306/ry_plus?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull" +
            "&transformedBitIsBoolean=true&allowMultiQueries=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";
    private static final String username = "root";
    private static final String password = "guirong";
    private static final List<String> tableNames = CollUtil.newArrayList();

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(url, username, password);

    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 数据库配置
                .dataSourceConfig((scanner, builder) -> builder.schema(scanner.apply("请输入表名称")))
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称")))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(scanner.apply("请输入表名，多个表名用,隔开")))
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker 或 Enjoy
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                   .templateEngine(new EnjoyTemplateEngine())
                 */
                .execute();
    }
}
