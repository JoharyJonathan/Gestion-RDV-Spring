package com.johary.rdvpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.johary.rdvpt.repositories")
public class RdvptApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdvptApplication.class, args);
	}

}
