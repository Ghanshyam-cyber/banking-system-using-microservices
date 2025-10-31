package com.banking_system.account_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI accountOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Account Service Api")
                        .description("Account Microservice REST Api")
                        .version("1.0.0"));
    }
}
