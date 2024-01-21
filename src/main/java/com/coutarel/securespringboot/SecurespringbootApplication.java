package com.coutarel.securespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurespringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurespringbootApplication.class, args);
	}

}
