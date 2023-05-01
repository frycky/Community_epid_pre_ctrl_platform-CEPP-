package com.agentp.cepp.configs;

import com.agentp.cepp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Resource
    LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                //允许直接访问的接口
                .excludePathPatterns(
                        "/user-info/save",
                        "/user-info/page1",
                        "/user-info/page2",
                        "/user-info/list",
                        "/user-info/pageUser",
                        "/user-info/updateUser",
                        "/user-info/delBatch",
                        "/article/detail",
                        "/menu-list/**",
                        "/**",
                        //TODO 开发暂时允许访问
                        "/doc.html",
                        "/user-info/getById",
                        "/user-info/postlogin",
                        "/user-info/register",
                        "/user-info/savetosql",
                        "/word-info/list",
                        "/word-info/saveTitle",
                        "/word-info/deleteTitle",
                        "/word-info/pageTitle",
                        "/word-info/pageArticle",
//
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/images/**",
                        "/webjars/**",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/configuration/security"
                );
    }

}
