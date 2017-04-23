package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.config.EventsConfig;

@RestController
public class PropertiesController {
	@Autowired
	EventsConfig eventsConfig;
	
	@GetMapping("/events") 
	public EventsConfig getEventsConfig()  {
		return eventsConfig;
	}

}
