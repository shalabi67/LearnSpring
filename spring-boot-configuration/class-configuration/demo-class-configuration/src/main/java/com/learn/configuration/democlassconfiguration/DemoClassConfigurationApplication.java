package com.learn.configuration.democlassconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.learn.configuration",
		//"com.learn.configuration.schoolframework.controllers"
})
public class DemoClassConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoClassConfigurationApplication.class, args);
	}
}
