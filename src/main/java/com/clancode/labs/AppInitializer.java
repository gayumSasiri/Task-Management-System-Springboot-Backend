package com.clancode.labs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.clancode.labs")
@EnableJpaRepositories("com.clancode.labs")
public class AppInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class);
    }
}
