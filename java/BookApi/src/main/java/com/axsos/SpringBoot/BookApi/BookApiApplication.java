package com.axsos.SpringBoot.BookApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.axsos.SpringBoot")
@EntityScan(basePackages = "com.axsos.SpringBoot")
@EnableJpaRepositories(basePackages = "com.axsos.SpringBoot")
public class BookApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApiApplication.class, args);
    }
}