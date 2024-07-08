package com.sun.xxm.utils;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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

    @Bean
    public OpenAPI restfulOpenAPI() {
        List<Server> listServers = new ArrayList<Server>();
        listServers.add(new Server().url(server));

        return new OpenAPI()
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
