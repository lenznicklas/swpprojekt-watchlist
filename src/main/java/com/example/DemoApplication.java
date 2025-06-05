package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = "com.example"              // scannt com.example.* (Controller, Services, Repos)
)
@EntityScan("com.example.models")               // findet @Entity in com.example.models
@EnableJpaRepositories("com.example.repositories") // aktiviert Deine Repositories
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
