package io.github.henriqueaguiiar.user_registry_core_api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Cadastro de Usuários API")
                        .description("API para mentoria de desenvolvimento backend.")
                        .version("Versão 1.0.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Henrique Aguiar")
                                .email("henriqueaguiarpacheco09@gmail.com")
                                .url("https://github.com/henriqueaguiiar")));
    }
}

