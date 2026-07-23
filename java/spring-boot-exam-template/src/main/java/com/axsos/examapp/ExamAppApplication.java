package com.axsos.examapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamAppApplication.class, args);
    }

    /*
     * وضعنا BCrypt هنا حتى يبقى عندنا فقط 4 packages:
     * controllers, models, repositories, services
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
