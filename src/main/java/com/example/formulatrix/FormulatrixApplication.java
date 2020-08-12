package com.example.formulatrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.formulatrix")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.formulatrix"} )
@EnableJpaRepositories("com.example.formulatrix")
public class FormulatrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(FormulatrixApplication.class, args);
	}
}
