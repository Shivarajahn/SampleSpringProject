package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.*")
@EnableJpaRepositories("com.sample.dao")
@EntityScan("com.sample.model")
public class SampleSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringProjectApplication.class, args);
	}
}
