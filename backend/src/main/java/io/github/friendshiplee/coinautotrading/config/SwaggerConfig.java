package io.github.friendshiplee.coinautotrading.config;

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
                    .title("코인 자동매매 API 명세서")
                    .version("v1.0.0")
                    .description("Spring Boot 기반 코인 자동매매 프로젝트의 Swagger 문서입니다."));
    }
}
