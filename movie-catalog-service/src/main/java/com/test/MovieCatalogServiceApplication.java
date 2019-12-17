package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.logging.Logger;

@SpringBootApplication
public class MovieCatalogServiceApplication {
    Logger log = Logger.getLogger("MovieCatalogServiceApplication");

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getTemplate() {
        System.out.println("RestTemplate ");
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder getWebClient() {
        System.out.println("WebClient.Builder........ ");
        return WebClient.builder();
    }

}
