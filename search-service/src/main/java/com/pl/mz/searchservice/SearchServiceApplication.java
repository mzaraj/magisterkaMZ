package com.pl.mz.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class SearchServiceApplication {
    //ten serwis jest oddzielnym wejsciem i wyszukuje wszytskie ksiazki oraz te ktore uzytkownik juz ocenił.

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
