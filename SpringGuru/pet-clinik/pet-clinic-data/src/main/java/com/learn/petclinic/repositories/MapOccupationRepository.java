package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Occupation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier(MapOccupationRepository.ID)
public class MapOccupationRepository implements OccupationRepository{
	public static final String ID = "MapOccupationRepository";
	private MapRepository<Occupation, Short> mapRepository = new MapRepository<>();
	@Override public <S extends Occupation> S save(S s) {
		return mapRepository.save(s);
	}

	@Override public <S extends Occupation> Iterable<S> saveAll(Iterable<S> iterable) {
		return mapRepository.saveAll(iterable);
	}

	@Override public Optional<Occupation> findById(Short aShort) {
		return mapRepository.findById(aShort);
	}

	@Override public boolean existsById(Short aShort) {
		return mapRepository.existsById(aShort);
	}

	@Override public Iterable<Occupation> findAll() {
		return mapRepository.findAll();
	}

	@Override public Iterable<Occupation> findAllById(Iterable<Short> iterable) {
		return mapRepository.findAllById(iterable);
	}

	@Override public long count() {
		return mapRepository.count();
	}

	@Override public void deleteById(Short aShort) {
		mapRepository.deleteById(aShort);
	}

	@Override public void delete(Occupation occupation) {
		mapRepository.delete(occupation);
	}

	@Override public void deleteAll(Iterable<? extends Occupation> iterable) {
		mapRepository.deleteAll(iterable);
	}

	@Override public void deleteAll() {
		mapRepository.deleteAll();
	}
}
