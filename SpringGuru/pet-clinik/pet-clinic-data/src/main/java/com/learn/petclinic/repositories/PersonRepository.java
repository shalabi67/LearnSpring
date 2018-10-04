package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	Iterable<Person> findAllByOccupation_Name(String occupationName);
}