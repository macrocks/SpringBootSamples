package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

@SpringBootApplication(exclude={LiquibaseAutoConfiguration.class}) //exclude liquibase to disable autorun data migration
public class SpringBootLiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLiquibaseApplication.class, args);
	}
}
