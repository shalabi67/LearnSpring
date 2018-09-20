package com.learn.testing.test_springboot.integration_tests.configurations;

import com.learn.testing.test_springboot.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.learn.testing.test_springboot")
public class SchoolServiceConfiguration {

}
