package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TruyumMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumMicroserviceApplication.class, args);
	}

}
