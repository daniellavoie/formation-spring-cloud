package com.invivoo.spring.cloud.validationservice;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@EntityScan
@Configuration
public class ValidationAutoConfiguration {
	@Bean
	public UserValidation userValidation() {
		return new UserValidation();
	}
}
