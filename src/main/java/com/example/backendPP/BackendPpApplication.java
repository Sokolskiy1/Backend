package com.example.backendPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendPpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPpApplication.class, args);
	}

}
/*spring.datasource.url= jdbc:postgresql://localhost:5432/backend
spring.datasource.jdbc-url=${spring.datasource.url}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.sql.init.platform=postgres
spring.datasource.username=postgres
spring.datasource.password=123
spring.jpa.generate-ddl=true*/