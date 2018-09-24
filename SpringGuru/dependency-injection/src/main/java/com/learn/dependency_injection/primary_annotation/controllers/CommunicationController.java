package com.learn.dependency_injection.primary_annotation.controllers;


import com.learn.dependency_injection.primary_annotation.services.CommunicationInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CommunicationController {
	private CommunicationInterface communicationInterface;

	public CommunicationController(@Qualifier("httpService") CommunicationInterface communicationInterface) {
		this.communicationInterface = communicationInterface;
	}

	public String getCommunication() {
		return communicationInterface.getProtocol();
	}
}
