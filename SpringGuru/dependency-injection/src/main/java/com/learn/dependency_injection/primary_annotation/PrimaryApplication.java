package com.learn.dependency_injection.primary_annotation;

import com.learn.dependency_injection.primary_annotation.controllers.CommunicationController;
import com.learn.dependency_injection.primary_annotation.controllers.DefaultCommunicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PrimaryApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PrimaryApplication.class, args);
		CommunicationController communicationController = (CommunicationController)applicationContext.getBean("communicationController");
		System.out.println(communicationController.getCommunication());

		DefaultCommunicationController defaultCommunicationController = (DefaultCommunicationController)applicationContext.getBean("defaultCommunicationController");
		System.out.println(defaultCommunicationController.getCommunication());
	}
}
