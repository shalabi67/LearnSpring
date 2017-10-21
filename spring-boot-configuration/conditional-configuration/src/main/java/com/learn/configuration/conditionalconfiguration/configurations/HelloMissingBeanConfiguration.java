package com.learn.configuration.conditionalconfiguration.configurations;

import com.learn.configuration.conditionalconfiguration.data.Hello;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mohammad on 10/21/2017.
 */
@Configuration
@ConditionalOnMissingBean(value={Hello.class})
public class HelloMissingBeanConfiguration {

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setHelloMessage("Hello from missing bean configuration due to missing property");
        return hello;
    }
}
