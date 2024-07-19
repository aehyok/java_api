package com.sun.xxm.utils;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * spring doc配置
 */
@Configuration
public class SpringDocConfig {
    @Value("${swagger.server}")
    private String server;

    private static final String SECURITY_SCHEME_NAME = "BearerAuth";

    @Bean
    public OpenAPI restfulOpenAPI() {
        List<Server> listServers = new ArrayList<Server>();
        listServers.add(new Server().url(server));

        return new OpenAPI()
                .components(new Components()
                // 设置 spring security jwt accessToken 认证的请求头 Authorization: Bearer xxx.xxx.xxx
                .addSecuritySchemes("openApiSecurityScheme", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .bearerFormat("JWT")
                        .in(SecurityScheme.In.HEADER)
                        .name("Authorization")
                        .scheme("Bearer")))
                .addSecurityItem(new SecurityRequirement().addList("openApiSecurityScheme"))
                .servers(listServers)
                .info(new Info().title("NCDP无代码开发平台")
                        .description("专为小项目而设计的后端接口服务")
                        .version("v0.0.1"));
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("SpringDoc Wiki Documentation")
//                        .url("https://springdoc.org/v2"));
    }

}
