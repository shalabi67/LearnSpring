package com.learn.springboot.configuration.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
/*
@Configuration
public class DisableAutoConfiguration {
    @Bean
    public FilterRegistrationBean disableHiddenHttpFilter(
            HiddenHttpMethodFilter hiddenHttpMethodFilter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(hiddenHttpMethodFilter);
        filterRegistrationBean.setEnabled(false);

        return filterRegistrationBean;
    }
}
*/