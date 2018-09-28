package com.learn.petclinic.bootstrap;

import com.learn.petclinic.configuration.MapRepositoryConfiguration;
import com.learn.petclinic.model.Occupation;
import com.learn.petclinic.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private CrudRepository<Person, Long> personRepository;

	public DataLoader(@Qualifier(MapRepositoryConfiguration.MappedPersonRepository)CrudRepository<Person, Long> personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Long occupationId = 0L;
		Occupation vet = addOccupation(++occupationId, "vet");
		Occupation owner = addOccupation(++occupationId, "owner");

		Long personId = 0L;
		//owners
		Person michael = addPerson(++personId, "Michael", "Weston", owner);
		Person fiona = addPerson(++personId, "Fiona", "Glenanne", owner);

		//vets
		Person sam = addPerson(++personId, "Sam", "Axe", vet);
		Person jessie = addPerson(++personId, "Jessie", "Porter", vet);


	}

	private Person addPerson(Long id, String firstName, String lastName, Occupation occupation) {
		Person person = Person.create(id, firstName, lastName, occupation);
		personRepository.save(person);

		return person;
	}

	private Occupation addOccupation(Long id, String name) {
		Occupation occupation = new Occupation(name);
		occupation.setId(id);

		return occupation;
	}
}
