package com.learn.dependency_injection.qualifier.services;

import org.springframework.stereotype.Service;

@Service
public class HttpsService implements CommunicationInterface {

	@Override public String getProtocol() {
		return "https";
	}
}
