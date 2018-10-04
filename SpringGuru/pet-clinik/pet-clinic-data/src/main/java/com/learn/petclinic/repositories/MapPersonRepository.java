package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Person;
import com.learn.petclinic.model.Pet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class MapPersonRepository implements PersonRepository {
	public static final String ID = "mapPersonRepository";

	//map of occupation and persons
	private Map<String, Set<Person>> occupationMap = new HashMap<>();
	private MapRepository<Person, Long> mapRepository = new MapRepository<>();
	private PetRepository mapPetRepository;
	public MapPersonRepository(@Qualifier(MapPetRepository.ID) PetRepository mapPetRepository) {
		this.mapPetRepository = mapPetRepository;
	}
	@Override public <S extends Person> S save(S s) {
		if(s == null)
			return null;
		Set<Pet> pets = s.getPets();
		if(pets != null && !pets.isEmpty()) {
			pets.forEach(pet -> mapPetRepository.save(pet));
		}
		if(s instanceof Person) {
			addPerson(s);
		}
		return mapRepository.save(s);
	}

	@Override public <S extends Person> Iterable<S> saveAll(Iterable<S> iterable) {
		return mapRepository.saveAll(iterable);
	}

	@Override public Optional<Person> findById(Long aLong) {
		return mapRepository.findById(aLong);
	}

	@Override public boolean existsById(Long aLong) {
		return mapRepository.existsById(aLong);
	}

	@Override public Iterable<Person> findAll() {
		return mapRepository.findAll();
	}

	@Override public Iterable<Person> findAllById(Iterable<Long> iterable) {
		return mapRepository.findAllById(iterable);
	}

	@Override public long count() {
		return mapRepository.count();
	}

	@Override public void deleteById(Long aLong) {
		mapRepository.deleteById(aLong);
	}

	@Override public void delete(Person person) {
		mapRepository.delete(person);
	}

	@Override public void deleteAll(Iterable<? extends Person> iterable) {
		mapRepository.deleteAll(iterable);
	}

	@Override public void deleteAll() {
		mapRepository.deleteAll();
	}

	private void addPerson(Person person) {
		String occupationName = ((Person)person).getOccupation().getName();
		Set<Person> personSet = occupationMap.getOrDefault(occupationName, new HashSet<Person>());
		personSet.add(person);
		occupationMap.put(occupationName, personSet);
	}

	@Override public Iterable<Person> findAllByOccupation_Name(String occupationName) {
		return occupationMap.getOrDefault(occupationName, new HashSet<Person>());
	}
}
