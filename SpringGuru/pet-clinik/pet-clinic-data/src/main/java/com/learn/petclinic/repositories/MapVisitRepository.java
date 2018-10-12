package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Visit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier(MapVisitRepository.ID)
public class MapVisitRepository implements VisitRepository {
	public static final String ID = "mapVisitRepository";

	private MapRepository<Visit, Long> mapRepository = new MapRepository<>();
	public MapVisitRepository() {

	}
	@Override public <S extends Visit> S save(S s) {
		return mapRepository.save(s);
	}

	@Override public <S extends Visit> Iterable<S> saveAll(Iterable<S> iterable) {
		return mapRepository.saveAll(iterable);
	}

	@Override public Optional<Visit> findById(Long aLong) {
		return mapRepository.findById(aLong);
	}

	@Override public boolean existsById(Long aLong) {
		return mapRepository.existsById(aLong);
	}

	@Override public Iterable<Visit> findAll() {
		return mapRepository.findAll();
	}

	@Override public Iterable<Visit> findAllById(Iterable<Long> iterable) {
		return mapRepository.findAllById(iterable);
	}

	@Override public long count() {
		return mapRepository.count();
	}

	@Override public void deleteById(Long aLong) {
		mapRepository.deleteById(aLong);
	}

	@Override public void delete(Visit pet) {
		mapRepository.delete(pet);
	}

	@Override public void deleteAll(Iterable<? extends Visit> iterable) {
		mapRepository.deleteAll(iterable);
	}

	@Override public void deleteAll() {
		mapRepository.deleteAll();
	}
}
