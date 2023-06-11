package com.ead.authuser.configs;

import org.springframework.boot.web.client.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // do any additional configuration here
        return builder.build();
    }
}
