package com.learn.spring.properties;

import com.learn.spring.properties.model.Fake;
import com.learn.spring.properties.model.JmsFake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PropertiesApplication.class, args);

		Fake fake = (Fake)context.getBean("fake");
		System.out.println("Username: " + fake.getUserName());
		System.out.println("Password: " + fake.getPassword());
		System.out.println("Url: " + fake.getUrl());

		JmsFake jmsFake = (JmsFake)context.getBean("jmsFake");
		System.out.println("Username: " + jmsFake.getUserName());
		System.out.println("Password: " + jmsFake.getPassword());
		System.out.println("Url: " + jmsFake.getUrl());
	}
}
