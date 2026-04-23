package com.idev.shop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI vegetableShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("iDEV Vegetable Shop API")
                        .description("Tài liệu API cho hệ thống cửa hàng rau củ quả iDEV")
                        .version("v1.0.0"));
    }
}
