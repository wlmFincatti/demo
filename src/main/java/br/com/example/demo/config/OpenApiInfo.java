package br.com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Getter
@Setter
@ConfigurationProperties(prefix = "openapi.info")
@Configuration
public class OpenApiInfo {

    private String version;
    private String title;
    private String description;
    private String email;
    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .servers(Arrays.asList(
                new Server().description("Env Local").url(String.format("http://localhost:%s", serverProperties.getPort())),
                new Server().description("Env Test").url("http://teste")
            ))
            .info(new Info()
                .title(title)
                .version(version)
                .description(description)
                .contact(new Contact().email(email))
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")));
    }
}
