package com.learn.petclinic.repositories.factory;

import com.learn.petclinic.repositories.OccupationRepository;
import com.learn.petclinic.repositories.PersonRepository;
import com.learn.petclinic.repositories.SpecialityRepository;

public class RepositoryContainer {
	private PersonRepository personRepository;
	private OccupationRepository occupationRepository;
	private SpecialityRepository specialityRepository;

	public RepositoryContainer(PersonRepository personRepository,
			OccupationRepository occupationRepository,
			SpecialityRepository specialityRepository) {
		this.personRepository = personRepository;
		this.occupationRepository = occupationRepository;
		this.specialityRepository = specialityRepository;
	}
	public PersonRepository getPersonRepository() {
		return personRepository;
	}
	public OccupationRepository getOccupationRepository() {
		return occupationRepository;
	}

	public SpecialityRepository getSpecialityRepository() {
		return specialityRepository;
	}
}
