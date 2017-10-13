package com.learn.cloud.service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Value("${service.instance.name}")
    private String serviceName;

    @RequestMapping("/")
    public String getWelcome() {
        return "Welcome I am a client for " + serviceName;
    }
}
