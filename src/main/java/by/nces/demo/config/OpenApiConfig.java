package by.nces.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Account Service Api",
        description = "Account Service", version = "1.0.0",
        contact = @Contact(
            name = "Anashkevich Aliaksandr",
            url = "https://github.com/AliaksandrAnashkevich"
        )
    )
)
public class OpenApiConfig {

}
