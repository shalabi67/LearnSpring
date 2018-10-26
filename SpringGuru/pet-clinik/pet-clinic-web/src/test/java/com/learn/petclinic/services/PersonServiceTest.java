package com.learn.petclinic.services;

import com.learn.petclinic.facade.data.PersonsData;
import com.learn.petclinic.model.Occupation;
import com.learn.petclinic.model.Person;
import com.learn.petclinic.repositories.PersonRepository;
import com.learn.petclinic.repositories.factory.RepositoryContainer;
import com.learn.petclinic.repositories.factory.RepositoryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PersonServiceTest {

	private PersonService peronService;

	@Mock
	private PersonRepository personRepository;

	@Mock
	private RepositoryFactory repositoryFactory;

	@BeforeEach
	void setUp() {
		//MockitoAnnotations.initMocks(this);
		initRepositoryFactory();
		peronService = new PersonService(repositoryFactory);
	}

	@Test
	void getOwners() {
		assertEquals(3, peronService.getOwners().size());
	}

	@Test
	void getVets() {
		assertEquals(2, peronService.getVets().size());
	}

	private void initRepositoryFactory() {
		Mockito.when(personRepository.findAllByOccupation_Name(Occupation.owner)).thenReturn(Arrays.asList(owners));
		Mockito.when(personRepository.findAllByOccupation_Name(Occupation.vet)).thenReturn(Arrays.asList(vets));

		Mockito.when(repositoryFactory.getRepositoryContainer())
				.thenReturn(new RepositoryContainer(personRepository, null, null));
	}

	Person[] owners = PersonsData.getOwners();
	Person[] vets = PersonsData.getVets();



}