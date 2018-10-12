package com.learn.petclinic.repositories;

import com.learn.petclinic.model.BaseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MapRepository<T extends BaseModel<ID>, ID> implements CrudRepository<T, ID> {
	Short identity = 0;


	private Map<ID, T> repositoryMap = new HashMap<>();
	@Override public <S extends T> S save(S s) {
		ID id = s.getId();
		if(id == null) {
			++identity;
			id = (ID)identity;
			s.setId(id);
		}
		repositoryMap.put(id, s);

		return s;
	}

	@Override public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
		throw new NotImplementedException();
	}

	@Override public Optional<T> findById(ID id) {
		T data = repositoryMap.getOrDefault(id, null);
		Optional<T> optional = Optional.ofNullable(data);
		return optional;
	}

	@Override public boolean existsById(ID id) {
		return repositoryMap.containsKey(id);
	}

	@Override public Iterable<T> findAll() {
		return repositoryMap.values();
	}

	@Override public Iterable<T> findAllById(Iterable<ID> iterable) {
		throw new NotImplementedException();
	}

	@Override public long count() {
		return repositoryMap.size();
	}

	@Override public void deleteById(ID id) {
		repositoryMap.remove(id);
	}

	@Override public void delete(T t) {
		repositoryMap.remove(t.getId());
	}

	@Override public void deleteAll(Iterable<? extends T> iterable) {
		throw new NotImplementedException();
	}

	@Override public void deleteAll() {
		repositoryMap = new HashMap<>();
	}


}
