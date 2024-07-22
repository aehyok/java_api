package com.sun.xxm.utils.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<String>();
        patterns.add("/swagger-ui/**");
        patterns.add("/v3/api-docs");
        patterns.add("/v3/api-docs/*");

        registry.addInterceptor(new TokenValidationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);  // 应用到所有URL
    }
}
