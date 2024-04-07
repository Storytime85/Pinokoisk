package com.storytime.pinokoiskmainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
public class PinokoiskApplication {


    public static void main(String[] args) {
        SpringApplication.run(PinokoiskApplication.class, args);
    }

}
