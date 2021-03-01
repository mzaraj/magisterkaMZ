package com.pl.mz.gameinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.TimeZone;

@EnableEurekaClient
@SpringBootApplication
public class GameInfoServiceApplication {

    public static void main(String[] args) {
        System.out.println(TimeZone.getDefault());
        SpringApplication.run(GameInfoServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
