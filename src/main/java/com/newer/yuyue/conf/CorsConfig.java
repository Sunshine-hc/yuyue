package com.newer.yuyue.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Configuration : 注解为工具类
 */
@Configuration
public class CorsConfig {

    //跨域访问来源服务器地址
    private String[] origins = new String[]{
            "localhost",
            "127.0.0.1",
            "localhost:8080"
    };

    @Bean
    public CorsFilter corsFilter(){
        //配置跨域访问策略
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //添加允许访问的地址列表
//        for (String origin:origins){
//            corsConfiguration.addAllowedOrigin("http://"+origin);
//            corsConfiguration.addAllowedOrigin("https://"+origin);
//        }
        //不对跨域源做任何限制  开放式授权
        corsConfiguration.addAllowedOrigin("*");
        //不限制头部数据
        corsConfiguration.addAllowedHeader("*");
        //不限制访问方法
        corsConfiguration.addAllowedMethod("*");
        //允许发送cookie和http认证信息
        //corsConfiguration.setAllowCredentials(true);
        //配置基于路径访问的跨域访问源对象
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置当前后端接口，从根目录开始的所有访问路径，都使用已经设置好的跨域访问策略
        source.registerCorsConfiguration("/**",corsConfiguration);
        //返回跨域访问过滤器，使用配置好的跨域访问策略
        return new CorsFilter(source);
    }
}
