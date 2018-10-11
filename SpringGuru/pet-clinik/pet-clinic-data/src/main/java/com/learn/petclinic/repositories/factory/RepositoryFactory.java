package com.learn.petclinic.repositories.factory;

import com.learn.petclinic.repositories.MapOccupationRepository;
import com.learn.petclinic.repositories.MapPersonRepository;
import com.learn.petclinic.repositories.MapSpecialityRepository;
import com.learn.petclinic.repositories.OccupationRepository;
import com.learn.petclinic.repositories.PersonRepository;
import com.learn.petclinic.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RepositoryFactory {
	@Value("${storageType}")
	String storageType;

	private PersonRepository personRepository;
	private PersonRepository mapPersonRepository;

	private OccupationRepository occupationRepository;
	private OccupationRepository mapOccupationRepository;

	private SpecialityRepository specialityRepository;
	private SpecialityRepository mapSpecialityRepository;

	@Bean
	RepositoryContainer databaseRepositoryFactory() {
		return new RepositoryContainer(personRepository, occupationRepository, specialityRepository);
	}

	@Bean
	RepositoryContainer mapRepositoryFactory() {
		return new RepositoryContainer(mapPersonRepository, mapOccupationRepository, mapSpecialityRepository);
	}

	public RepositoryFactory(PersonRepository personRepository, @Qualifier(MapPersonRepository.ID)PersonRepository mapPersonRepository,
			OccupationRepository occupationRepository, @Qualifier(MapOccupationRepository.ID)OccupationRepository mapOccupationRepository,
			SpecialityRepository specialityRepository, @Qualifier(MapSpecialityRepository.ID)SpecialityRepository mapSpecialityRepository) {
		this.personRepository = personRepository;
		this.occupationRepository = occupationRepository;
		this.specialityRepository = specialityRepository;


		this.mapPersonRepository = mapPersonRepository;
		this.mapOccupationRepository = mapOccupationRepository;
		this.mapSpecialityRepository = mapSpecialityRepository;
	}

	public RepositoryContainer getRepositoryContainer() {
		if(storageType.equals("database")) {
			return databaseRepositoryFactory();
		}
		if(storageType.equals("map")) {
			return mapRepositoryFactory();
		}

		return databaseRepositoryFactory();
	}
}
