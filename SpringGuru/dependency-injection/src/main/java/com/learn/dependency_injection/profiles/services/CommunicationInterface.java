package com.learn.dependency_injection.profiles.services;

import org.springframework.stereotype.Service;

@Service
public interface CommunicationInterface {
	String getProtocol();
}
