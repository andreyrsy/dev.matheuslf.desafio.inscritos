package dev.matheuslf.desafio.inscritos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                .title("Gerenciador de projetos")
                .version("1.0")
                .description("Desafio de um gerenciador projetos com tasks")
                .contact(new Contact().name("").email("andreyrsy@gmail.com")));
    }
}

