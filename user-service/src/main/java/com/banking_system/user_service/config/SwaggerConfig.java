package com.banking_system.user_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI userOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("User Service Api.")
                        .description("User Microservice REST API")
                        .version("1.0.0"));
    }
}
