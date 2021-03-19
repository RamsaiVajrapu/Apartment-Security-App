package com.cg.aps.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cg.aps")
@EntityScan(basePackages = "com.cg.aps.entity")
@EnableJpaRepositories(basePackages = "com.cg.aps.dao")
public class ApartmentSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentSecurityAppApplication.class, args);
	}

}