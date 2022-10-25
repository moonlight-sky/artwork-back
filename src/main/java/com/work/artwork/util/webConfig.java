package com.work.artwork.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//全局配置类--配置跨域请求
//说明，这是一个全局配置类
@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
        * 1、域访问的路径
        * 2、请求来源
        * 3、方法
        * 4、允许携带token
        * 5、最大响应时间
        * */
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","OPTION","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
