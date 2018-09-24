package com.learn.dependency_injection.primary_annotation.controllers;


import com.learn.dependency_injection.primary_annotation.services.CommunicationInterface;
import org.springframework.stereotype.Controller;

@Controller
public class DefaultCommunicationController {
	private CommunicationInterface communicationInterface;

	public DefaultCommunicationController(CommunicationInterface communicationInterface) {
		this.communicationInterface = communicationInterface;
	}

	public String getCommunication() {
		return communicationInterface.getProtocol();
	}
}
