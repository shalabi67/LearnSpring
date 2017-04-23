package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mvc.config.EventsConfig;

@EnableConfigurationProperties(EventsConfig.class)
@SpringBootApplication
public class EventTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventTrackerApplication.class, args);
	}
}
