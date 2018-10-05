package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Speciality;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier(MapSpecialityRepository.ID)
public class MapSpecialityRepository implements SpecialityRepository {
	public static final String ID = "mapSpecialityRepository";

	private MapRepository<Speciality, Short> mapRepository = new MapRepository<>();
	public MapSpecialityRepository() {

	}
	@Override public <S extends Speciality> S save(S s) {
		return mapRepository.save(s);
	}

	@Override public <S extends Speciality> Iterable<S> saveAll(Iterable<S> iterable) {
		return mapRepository.saveAll(iterable);
	}

	@Override public Optional<Speciality> findById(Short aLong) {
		return mapRepository.findById(aLong);
	}

	@Override public boolean existsById(Short aLong) {
		return mapRepository.existsById(aLong);
	}

	@Override public Iterable<Speciality> findAll() {
		return mapRepository.findAll();
	}

	@Override public Iterable<Speciality> findAllById(Iterable<Short> iterable) {
		return mapRepository.findAllById(iterable);
	}

	@Override public long count() {
		return mapRepository.count();
	}

	@Override public void deleteById(Short aLong) {
		mapRepository.deleteById(aLong);
	}

	@Override public void delete(Speciality pet) {
		mapRepository.delete(pet);
	}

	@Override public void deleteAll(Iterable<? extends Speciality> iterable) {
		mapRepository.deleteAll(iterable);
	}

	@Override public void deleteAll() {
		mapRepository.deleteAll();
	}
}
