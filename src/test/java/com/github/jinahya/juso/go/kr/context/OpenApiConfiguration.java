package com.github.jinahya.juso.go.kr.context;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApiConfiguration {

    @Bean
    public OpenAPI openApiInformation() {
//        Server localServer = new Server()
//                .url("http://localhost:8080")
//                .description("Localhost Server URL");
//
//        Contact contact = new Contact()
//                .email("niket.agrawal90@gmail.com")
//                .name("Niket Agrawal");
//
//        Info info = new Info()
//                .contact(contact)
//                .description("Spring Boot 3 + Open API 3")
//                .summary("Demo of Spring Boot 3 & Open API 3 Integration")
//                .title("Spring Boot 3 + Open API 3")
//                .version("V1.0.0")
//                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        return new OpenAPI();
    }
}
