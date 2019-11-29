package com.liangwc.ggblog.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @author liangweicheng
 * @date 2019/11/29 10:10
 */
public class Generator {
    public static void main(String[] args) {
        String packageName = "com.liangwc.ggblog";
        boolean serviceNameStartWithI = false;
        generateByTables(serviceNameStartWithI, packageName, "liangwc", "ggbolg", "gg_article_info");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String auth, String database, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost/ggbolg?useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperMapperClass("com.liangwc.ggblog.mapper.BaseMapper")
                .setInclude(tableNames);
        config.setActiveRecord(false)
                .setAuthor(auth)
                .setFileOverride(true)
                .setEnableCache(false);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(new PackageConfig().setParent(packageName)
                        .setController("controller")
                        .setEntity("entity")
                        .setMapper("mapper")
                        .setService("service")
                        .setServiceImpl("service.impl")
                        .setXml("mybatis.mappers")).execute();
    }
}
