package com.learn.dependency_injection.bean_lifecycle;

import com.learn.dependency_injection.qualifier.controllers.CommunicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanLifecycleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(BeanLifecycleApplication.class, args);
		BeanLifecycleExample beanLifecycleExample = (BeanLifecycleExample)applicationContext.getBean("beanLifecycleExample");
	}
}
