package com.safety.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/auth/**")
                .addResourceLocations("classpath:/auth/");
        registry.addResourceHandler("/lab/**")
                .addResourceLocations("classpath:/lab/");
        registry.addResourceHandler("/chemical/**")
                .addResourceLocations("classpath:/chemical/");
        registry.addResourceHandler("/waste/**")
                .addResourceLocations("classpath:/waste/");
        registry.addResourceHandler("/check/**")
                .addResourceLocations("classpath:/check/");
        registry.addResourceHandler("/education/**")
                .addResourceLocations("classpath:/education/");
    }
}