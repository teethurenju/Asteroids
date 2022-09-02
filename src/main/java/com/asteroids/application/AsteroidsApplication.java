package com.asteroids.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.asteroids.controller","com.asteroids.service"})
@EntityScan("com.asteroids.domain")
@EnableJpaRepositories("com.asteroids.repository")
public class AsteroidsApplication {

	public static void main(String args[]) {
		SpringApplication.run(AsteroidsApplication.class, args);
	}
}
