package br.com.soacheckpoint1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SOA - Checkpoint 1: API Loja Online")
                        .version("1.0")
                        .description("API REST para gerenciamento de clientes e produtos."));
    }
}
