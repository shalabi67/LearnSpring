package com.learn.petclinic.repositories;

import com.learn.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Short> {

}
