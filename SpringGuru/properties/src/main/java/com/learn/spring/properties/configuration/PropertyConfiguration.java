package com.learn.spring.properties.configuration;

import com.learn.spring.properties.model.Fake;
import com.learn.spring.properties.model.JmsFake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource("classpath:fake.properties")
@PropertySources({
		@PropertySource("classpath:fake.properties"),
		@PropertySource("classpath:jms.properties")
})
public class PropertyConfiguration {
	@Value("${guru.userName}")
	private String userName;
	@Value("${guru.password}")
	private String password;
	@Value("${gurul.databaseUrl}")
	private String url;

	@Value("${guru.jms.userName}")
	private String jmsUserName;
	@Value("${guru.jms.password}")
	private String jmsPassword;
	@Value("${gurul.jms.databaseUrl}")
	private String jmsUrl;

	@Bean Fake fake() {
		return new Fake(userName, password, url);
	}

	@Bean JmsFake jmsFake() {
		return new JmsFake(jmsUserName, jmsPassword, jmsUrl);
	}

	@Bean
	static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
