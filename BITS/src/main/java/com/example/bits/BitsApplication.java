package com.example.bits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitsApplication.class, args);
    }

}
