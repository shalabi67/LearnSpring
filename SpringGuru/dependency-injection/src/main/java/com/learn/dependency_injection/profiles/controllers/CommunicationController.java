package com.learn.dependency_injection.profiles.controllers;

import com.learn.dependency_injection.profiles.services.CommunicationInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CommunicationController {
	private CommunicationInterface communicationInterface;

	public CommunicationController(CommunicationInterface communicationInterface) {
		this.communicationInterface = communicationInterface;
	}

	public String getCommunication() {
		return communicationInterface.getProtocol();
	}
}
