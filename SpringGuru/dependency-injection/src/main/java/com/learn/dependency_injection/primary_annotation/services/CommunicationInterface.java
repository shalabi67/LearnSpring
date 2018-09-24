package com.learn.dependency_injection.primary_annotation.services;

import org.springframework.stereotype.Service;

@Service
public interface CommunicationInterface {
	String getProtocol();
}
