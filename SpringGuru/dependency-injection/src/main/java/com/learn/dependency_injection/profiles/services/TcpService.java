package com.learn.dependency_injection.profiles.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("tcp")
public class TcpService implements CommunicationInterface {

	@Override public String getProtocol() {
		return "tcp";
	}
}
