package com.vanshii.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.vanshii.spring.entities")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
