package com.learn.petclinic.bootstrap;

import com.learn.petclinic.model.Person;
import com.learn.petclinic.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private CrudRepository<Person, Long> ownerRepository;
	private CrudRepository<Person, Long> vetRepository;

	public DataLoader(CrudRepository<Person, Long> ownerRepository, CrudRepository<Person, Long> vetRepository) {
		this.ownerRepository = ownerRepository;
		this.vetRepository = vetRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Long id = 0L;
		//owners
		Person michael = addPerson(++id, "Michael", "Weston");
		Person fiona = addPerson(++id, "Fiona", "Glenanne");

		//vets
		Person sam = addPerson(++id, "Sam", "Axe");
		Person jessie = addPerson(++id, "Jessie", "Porter");


	}

	private Person addPerson(Long id, String firstName, String lastName) {
		Person person = Person.create(id, firstName, lastName);
		ownerRepository.save(person);

		return person;
	}
}
