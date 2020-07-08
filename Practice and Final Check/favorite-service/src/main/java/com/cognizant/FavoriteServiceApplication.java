package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient 
@EnableFeignClients("com.feignproxy")
public class FavoriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteServiceApplication.class, args);
	}

}