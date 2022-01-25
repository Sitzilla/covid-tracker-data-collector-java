package com.evansitzes.coviddatacollector.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        final String apiToken = System.getenv("apiToken");

        return requestTemplate -> {
            requestTemplate.header("X-App-Token", apiToken);
        };
    }
}
