package com.learn.petclinic.repositories;

import com.learn.petclinic.model.BaseModel;
import com.learn.petclinic.model.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapPersonRepository implements PersonRepository {
	public static final String ID = "mapPersonRepository";

	private MapRepository<Person, Long> mapRepository;
	public MapPersonRepository(MapRepository<Person, Long> mapRepository) {
		this.mapRepository = mapRepository;
	}
	@Override public <S extends Person> S save(S s) {
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

	@Override public Iterable<Person> findAllByOccupation_Name(String occupationName) {
		return mapRepository.findAllByOccupation(occupationName);
	}
}
