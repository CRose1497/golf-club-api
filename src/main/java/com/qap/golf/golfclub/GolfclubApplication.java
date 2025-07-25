package com.qap.golf.golfclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qap.golf.golfclub")
public class GolfclubApplication {
    public static void main(String[] args) {
        SpringApplication.run(GolfclubApplication.class, args);
    }
}
