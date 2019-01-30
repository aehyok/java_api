package com.example.demo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket ApplicationApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fakerswe")
                .select()  // 选择哪些路径和api会生成document
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .apiInfo(applicationInfo());//用来创建该Api的基本信息(这些基本信息会展现在文档页面中)
    }

    //测试
    private ApiInfo applicationInfo() {
        ApiInfo apiInfo = new ApiInfo("aehyok Api接口管理",//大标题
                "api接口可视化管理" ,//小标题
                "0.1",//版本
                "",
                "",
                "",//链接显示文字
                ""//网站链接
        );
        return apiInfo;
    }
}
