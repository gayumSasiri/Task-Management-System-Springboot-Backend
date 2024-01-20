package com.clancode.labs;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.clancode.labs")
@EnableJpaRepositories("com.clancode.labs")
public class AppInitializer {

    @Bean
    public ModelMapper mapper(){ return new ModelMapper(); }

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class);
    }
}
