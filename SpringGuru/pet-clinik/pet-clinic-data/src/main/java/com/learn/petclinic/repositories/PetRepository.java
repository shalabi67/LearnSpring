package com.learn.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository<T, ID> extends CrudRepository<T, ID> {

}
