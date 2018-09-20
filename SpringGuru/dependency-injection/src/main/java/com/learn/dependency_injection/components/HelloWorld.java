package com.learn.dependency_injection.components;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	public void show() {
		System.out.println("Hello, world");
	}
}
