package com.learn.dependency_injection.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(HelloWorldApplication.class, args);
		HelloWorld helloWorld = (HelloWorld)applicationContext.getBean("helloWorld");
		helloWorld.show();
	}
}
