package com.moyoraq.busking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BuskingDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuskingDevelopApplication.class, args);
    }

}
