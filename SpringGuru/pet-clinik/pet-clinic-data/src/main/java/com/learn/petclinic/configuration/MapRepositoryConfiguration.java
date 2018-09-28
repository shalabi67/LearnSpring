package com.learn.petclinic.configuration;

import com.learn.petclinic.model.Person;
import com.learn.petclinic.repositories.MapRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public class MapRepositoryConfiguration {
	public static final String MappedPersonRepository = "MappedPersonRepository";
	@Bean
	@Qualifier(MappedPersonRepository)
	CrudRepository<Person, Long> mappedPersonRepository() {
		return create();
	}

	@Bean
	CrudRepository<Person, Long> vetRepository() {
		return create();
	}

	private CrudRepository<Person, Long> create() {
		CrudRepository<Person, Long> crudRepository = new MapRepository<>();

		return crudRepository;

	}
}
