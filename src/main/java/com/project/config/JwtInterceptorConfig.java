package com.project.config;

import com.project.Interceptor.JwtAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JwtInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自定义拦截器并将拦截路径添加
        //"/**"拦截所有
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public JwtAuthenticationInterceptor authenticationInterceptor() {
        return new JwtAuthenticationInterceptor();
    }

}
