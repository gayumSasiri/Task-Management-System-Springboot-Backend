package com.clancode.labs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.clancode.labs")
public class AppInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class);
    }
}
