package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Pet;
import com.learn.petclinic.model.PetType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier(MapPetRepository.ID)
public class MapPetRepository implements PetRepository {
	public static final String ID = "mapPetRepository";

	private MapRepository<Pet, Long> mapRepository = new MapRepository<>();
	private PetTypeRepository petTypeRepository;
	public MapPetRepository(@Qualifier(MapPetTypeRepository.ID)PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}
	@Override public <S extends Pet> S save(S s) {
		if(s == null)
			return null;
		PetType petType = s.getPetType();
		if(petType != null && petType.getId() == null) {
			petTypeRepository.save(petType);
		}
		return mapRepository.save(s);
	}

	@Override public <S extends Pet> Iterable<S> saveAll(Iterable<S> iterable) {
		return mapRepository.saveAll(iterable);
	}

	@Override public Optional<Pet> findById(Long aLong) {
		return mapRepository.findById(aLong);
	}

	@Override public boolean existsById(Long aLong) {
		return mapRepository.existsById(aLong);
	}

	@Override public Iterable<Pet> findAll() {
		return mapRepository.findAll();
	}

	@Override public Iterable<Pet> findAllById(Iterable<Long> iterable) {
		return mapRepository.findAllById(iterable);
	}

	@Override public long count() {
		return mapRepository.count();
	}

	@Override public void deleteById(Long aLong) {
		mapRepository.deleteById(aLong);
	}

	@Override public void delete(Pet pet) {
		mapRepository.delete(pet);
	}

	@Override public void deleteAll(Iterable<? extends Pet> iterable) {
		mapRepository.deleteAll(iterable);
	}

	@Override public void deleteAll() {
		mapRepository.deleteAll();
	}
}
