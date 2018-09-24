package com.learn.dependency_injection.qualifier.services;

import org.springframework.stereotype.Service;

@Service
public interface CommunicationInterface {
	String getProtocol();
}
