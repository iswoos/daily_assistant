package com.side_project.daily_assistant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("Custom-Header")
                // 해당 내용에 true를 쓸 경우, allowedOrigins에 와일드문자 * 를 쓸 수 없음
                // 보안상의 이유로, 특정 출처에서만 허용하기 위함 (구체적인 도메인 명시 필요)
                .allowCredentials(true)
                .maxAge(3600);
    }
}
