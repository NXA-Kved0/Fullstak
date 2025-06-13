package com.inscripcion.inscripcion.Config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenapi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API 2026 Inscripciones")
                        .version("1.0")
                        .description("Incripcion de estudiantes"));

    }
}
