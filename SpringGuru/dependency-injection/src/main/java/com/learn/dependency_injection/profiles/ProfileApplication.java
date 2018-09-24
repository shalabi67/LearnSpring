package com.learn.dependency_injection.profiles;

import com.learn.dependency_injection.profiles.controllers.CommunicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProfileApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ProfileApplication.class, args);
		CommunicationController communicationController = (CommunicationController)applicationContext.getBean("communicationController");
		System.out.println(communicationController.getCommunication());
	}
}
