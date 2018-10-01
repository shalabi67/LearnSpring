package com.learn.petclinic.services;

import com.learn.petclinic.model.Occupation;
import com.learn.petclinic.model.Person;
import com.learn.petclinic.repositories.MapPersonRepository;
import com.learn.petclinic.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {

	private PersonRepository personRepository;

	public PersonService(@Qualifier(MapPersonRepository.ID)PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Set<Person> getOwners() {
		Iterable<Person> list = personRepository.findAllByOccupation_Name(Occupation.owner);
		return toList(list);
	}

	public Set<Person> getVets() {
		Iterable<Person> list = personRepository.findAllByOccupation_Name(Occupation.vet);
		return toList(list);
	}

	private Set<Person> toList(Iterable<Person> iterable) {
		final Set<Person> persons = new HashSet<>();
		iterable.forEach(persons::add);

		return persons;
	}
}
