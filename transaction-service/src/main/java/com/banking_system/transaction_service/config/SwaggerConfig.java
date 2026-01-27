package com.banking_system.transaction_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI transactionOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Transaction Service Api")
                .description("Transaction Microservice REST Api")
                .version("1.0.0")
        );
    }
}
