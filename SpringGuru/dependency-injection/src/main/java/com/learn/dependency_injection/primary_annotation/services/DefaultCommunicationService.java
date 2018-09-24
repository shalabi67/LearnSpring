package com.learn.dependency_injection.primary_annotation.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DefaultCommunicationService implements CommunicationInterface {

	@Override public String getProtocol() {
		return "default tcp";
	}
}
