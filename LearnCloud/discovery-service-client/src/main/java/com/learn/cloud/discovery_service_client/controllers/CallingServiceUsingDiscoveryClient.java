package com.learn.cloud.discovery_service_client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CallingServiceUsingDiscoveryClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service/{serviceId}")
    public String callService(@PathVariable int serviceId) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service");
        String serviceUrl = serviceInstances.get(serviceId).getUri().toString();

        RestTemplate restTemplate = restTemplateBuilder.build();
        String result = restTemplate.getForObject(serviceUrl, String.class);
        return result;
    }
}
