package com.learn.configuration.conditionalconfiguration.configurations;

import com.learn.configuration.conditionalconfiguration.data.Hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;

/**
 * Created by mohammad on 10/21/2017.
 */
@Configuration
@ConditionalOnProperty({HelloAutoConfiguration.HELLO_PROPERTY_NAME})
public class HelloAutoConfiguration {
    public static final String HELLO_PROPERTY_NAME = "configuration.hello";

    @Value("${configuration.hello}")
    private String helloMessage;

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setHelloMessage(helloMessage);
        return  hello;
    }

}
