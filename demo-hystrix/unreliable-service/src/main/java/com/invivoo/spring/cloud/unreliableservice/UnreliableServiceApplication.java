package com.invivoo.spring.cloud.unreliableservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UnreliableServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnreliableServiceApplication.class, args);
	}
}
