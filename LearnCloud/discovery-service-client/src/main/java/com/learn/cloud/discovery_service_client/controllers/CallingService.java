package com.learn.cloud.discovery_service_client.controllers;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallingService {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping("/")
    public String callService() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service", false);
        String serviceUrl = instanceInfo.getHomePageUrl();

        RestTemplate restTemplate = restTemplateBuilder.build();
        String result = restTemplate.getForObject(serviceUrl, String.class);
        return result;
    }
}
