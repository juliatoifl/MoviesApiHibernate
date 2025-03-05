package com.example.MoviesApiHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repositories")
@EntityScan(basePackages = "entities")
public class MoviesApiHibernateApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviesApiHibernateApplication.class, args);
	}
}
