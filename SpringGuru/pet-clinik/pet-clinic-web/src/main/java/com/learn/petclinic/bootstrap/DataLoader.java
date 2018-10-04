package com.learn.petclinic.bootstrap;

import com.learn.petclinic.model.Occupation;
import com.learn.petclinic.model.Person;
import com.learn.petclinic.model.Pet;
import com.learn.petclinic.model.PetType;
import com.learn.petclinic.repositories.MapPersonRepository;
import com.learn.petclinic.repositories.MapPetTypeRepository;
import com.learn.petclinic.repositories.PersonRepository;
import com.learn.petclinic.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
		PetType dog = addPetType( "DOG");
		PetType cat = addPetType("CAT");



		Long occupationId = 0L;
		Occupation vet = addOccupation(++occupationId, Occupation.vet);
		Occupation owner = addOccupation(++occupationId, Occupation.owner);

		Long personId = 0L;
		//owners
		Person michael = addPerson("Michael", "Weston", "address1", "city1", "123456", owner);
		Person fiona = addPerson("Fiona", "Glenanne", "address2", "city2", "123456",owner);

		//vets
		Person sam = addPerson("Sam", "Axe", "address3", "city3", "123456",vet);
		Person jessie = addPerson( "Jessie", "Porter", "address4", "city4", "123456",vet);



		Pet pet1 = new Pet(dog, michael, LocalDate.parse("1999-12-31"), "dog1");
		Pet pet2 = new Pet(cat, fiona, LocalDate.parse("1999-12-31"), "cat1");



		personRepository.save(michael);
		personRepository.save(fiona);
		personRepository.save(sam);
		personRepository.save(jessie);


	}


	private Person addPerson(String firstName, String lastName,
			String address, String city, String phoneNumber,
			Occupation occupation) {
		Person person = new Person(firstName, lastName, address, city, phoneNumber, occupation);
		//personRepository.save(person);

		return person;
	}

	private Occupation addOccupation(Long id, String name) {
		Occupation occupation = new Occupation(name);
		occupation.setId(id);

		return occupation;
	}

	private PetType addPetType(String name) {
		PetType petType = new PetType(name);
		return petType;
	}
}
