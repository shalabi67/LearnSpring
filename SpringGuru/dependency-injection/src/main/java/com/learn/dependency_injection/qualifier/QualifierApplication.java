package com.learn.dependency_injection.qualifier;

import com.learn.dependency_injection.components.HelloWorld;
import com.learn.dependency_injection.qualifier.controllers.CommunicationController;
import com.learn.dependency_injection.qualifier.services.CommunicationInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QualifierApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(QualifierApplication.class, args);
		CommunicationController communicationController = (CommunicationController)applicationContext.getBean("communicationController");
		System.out.println(communicationController.getCommunication());
	}
}
