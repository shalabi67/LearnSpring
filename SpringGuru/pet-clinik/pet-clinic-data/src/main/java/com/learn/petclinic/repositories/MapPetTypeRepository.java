package com.learn.petclinic.repositories;

import com.learn.petclinic.model.PetType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier(MapPetTypeRepository.ID)
public class MapPetTypeRepository implements PetTypeRepository {
	public static final String ID = "mapPetTypeRepository";

	private MapRepository<PetType, Short> mapRepository = new MapRepository<>();
	public MapPetTypeRepository() {

	}
	@Override public <S extends PetType> S save(S s) {
		return mapRepository.save(s);
	}

	@Override public <S extends PetType> Iterable<S> saveAll(Iterable<S> iterable) {
		return mapRepository.saveAll(iterable);
	}

	@Override public Optional<PetType> findById(Short aLong) {
		return mapRepository.findById(aLong);
	}

	@Override public boolean existsById(Short aLong) {
		return mapRepository.existsById(aLong);
	}

	@Override public Iterable<PetType> findAll() {
		return mapRepository.findAll();
	}

	@Override public Iterable<PetType> findAllById(Iterable<Short> iterable) {
		return mapRepository.findAllById(iterable);
	}

	@Override public long count() {
		return mapRepository.count();
	}

	@Override public void deleteById(Short aLong) {
		mapRepository.deleteById(aLong);
	}

	@Override public void delete(PetType pet) {
		mapRepository.delete(pet);
	}

	@Override public void deleteAll(Iterable<? extends PetType> iterable) {
		mapRepository.deleteAll(iterable);
	}

	@Override public void deleteAll() {
		mapRepository.deleteAll();
	}
}
