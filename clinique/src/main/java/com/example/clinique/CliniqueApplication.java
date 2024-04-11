package com.example.clinique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CliniqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(CliniqueApplication.class, args);
    }

}
