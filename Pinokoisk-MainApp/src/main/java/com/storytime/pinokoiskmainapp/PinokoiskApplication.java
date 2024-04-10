package com.storytime.pinokoiskmainapp;

import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
@EnableJpaRepositories(excludeFilters =
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ReviewRepository.class))
public class PinokoiskApplication {


    public static void main(String[] args) {
        SpringApplication.run(PinokoiskApplication.class, args);
    }

}
