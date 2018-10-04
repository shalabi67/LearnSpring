package com.learn.petclinic.bootstrap;

import com.learn.petclinic.model.Occupation;
import com.learn.petclinic.model.Person;
import com.learn.petclinic.model.PetType;
import com.learn.petclinic.repositories.MapPersonRepository;
import com.learn.petclinic.repositories.MapPetTypeRepository;
import com.learn.petclinic.repositories.PersonRepository;
import com.learn.petclinic.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private PersonRepository personRepository;
	private PetTypeRepository petTypeRepository;

	public DataLoader(@Qualifier(MapPersonRepository.ID)PersonRepository personRepository,
			@Qualifier(MapPetTypeRepository.ID)PetTypeRepository petTypeRepository) {
		this.personRepository = personRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Short petTypeId = 0;
		PetType dog = addPetType(++petTypeId, "DOG");
		PetType cat = addPetType(++petTypeId, "CAT");

		Long occupationId = 0L;
		Occupation vet = addOccupation(++occupationId, Occupation.vet);
		Occupation owner = addOccupation(++occupationId, Occupation.owner);

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

	private PetType addPetType(Short id, String name) {
		PetType petType = new PetType(name);
		petType.setId(id);

		petTypeRepository.save(petType);

		return petType;
	}
}
