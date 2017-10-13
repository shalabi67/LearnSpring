package com.learn.cloud.discovery_service_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceClientApplication.class, args);
	}
}
