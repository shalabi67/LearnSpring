package com.shalabi.unit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shalabi.facade.ShipwreckRepositoryImp;
import com.shalabi.repository.ShipwreckRepository;

@Configuration
public class ShipwreckConfiguration {
	@Bean
	public ShipwreckRepository getShipwreckRepository() {
	        return new ShipwreckRepositoryImp();
	}

}
