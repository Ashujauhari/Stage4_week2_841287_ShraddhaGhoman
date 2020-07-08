package com.cognizant.moviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MoviecruiserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviecruiserMicroserviceApplication.class, args);
	}

}
