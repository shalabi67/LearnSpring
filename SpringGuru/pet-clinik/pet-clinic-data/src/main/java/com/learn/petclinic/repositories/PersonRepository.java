package com.learn.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository<T, ID> extends CrudRepository<T, ID>{

}
