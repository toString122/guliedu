package com.liwj.service_edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @version 1.0<br>
 * @description:
 * @author: GLAD.liwj
 * @date: 2021/2/5 10:28
 */
@Configuration
@MapperScan("com.liwj.service_edu.mapper")
public class MpConfig {
    /**
     * 逻辑删除插件
     *
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 性能分析插件
     */
    @Bean
    @Profile({"dev", "test"})//设置dev环境开启配置
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // maxTime 指的是 sql 最大执行时长
        performanceInterceptor.setMaxTime(5000);
        //SQL是否格式化 默认false
        performanceInterceptor.setFormat(true);
        return new PerformanceInterceptor();
    }

    /**
     *
     * 分页插件
     *
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
