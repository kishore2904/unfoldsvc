package com.unfold.unfoldfit.configuration;

import com.unfold.unfoldfit.utils.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";

    public WebMvcConfigurer corsConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders(GET,POST,PUT,DELETE)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);                ;
            }

        };
    }
}
