package com.learn.dependency_injection.qualifier.services;

import org.springframework.stereotype.Service;

@Service
public class HttpService implements CommunicationInterface {

	@Override public String getProtocol() {
		return "http";
	}
}
