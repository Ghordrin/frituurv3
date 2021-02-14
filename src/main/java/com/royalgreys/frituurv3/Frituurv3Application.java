package com.royalgreys.frituurv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Frituurv3Application {

	public static void main(String[] args) {
		SpringApplication.run(Frituurv3Application.class, args);
	}

}
