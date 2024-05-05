package tgkt.toliver.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(type = SecuritySchemeType.HTTP, name = "JWT", scheme = "Bearer")
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPIConfig() {
        System.out.println("aaaaa a a a a a a a a a");
        return new OpenAPI()
                .info(info());
    }

    private Info info() {
        return new Info()
                .title("Toliver Documentation - Toliver API文档")
                .version("V0.0.1")
                .description("这是ToliverAPI文档");
    }
}
