package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages= "com.example.demo")
public class DemoApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("spring.datasource.username", dotenv.get("POSTGRES_USER"));
		System.setProperty("spring.datasource.password", dotenv.get("POSTGRES_PASSWORD"));
		System.setProperty("spring.datasource.url", "jdbc:postgresql://postgres:5432/" + dotenv.get("POSTGRES_DB"));
		SpringApplication.run(DemoApplication.class, args);
	}

}
