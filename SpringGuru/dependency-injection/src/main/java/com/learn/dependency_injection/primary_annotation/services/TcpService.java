package com.learn.dependency_injection.primary_annotation.services;

import org.springframework.stereotype.Service;

@Service
public class TcpService implements CommunicationInterface {

	@Override public String getProtocol() {
		return "tcp";
	}
}
