package com.invivoo.springboot.plain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = { PlainApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
public class PlainApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlainApplication.class, args);
	}
}
