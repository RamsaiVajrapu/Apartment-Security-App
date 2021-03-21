package com.cg.aps.application;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.cg.aps")
@EntityScan(basePackages = "com.cg.aps.entity")
@EnableJpaRepositories(basePackages = "com.cg.aps.dao")
@EnableOpenApi
public class ApartmentSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentSecurityAppApplication.class, args);
	}
	
	@Bean
	  public Docket openApiSecurityApp() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-apartment-security-app")
	        .select()
	        .paths(secPaths())
	        .build();
	  }

	  private Predicate<String> secPaths() {
	    return regex(".*/api/.*");
	  }

}