package com.learn.petclinic.repositories;

import com.learn.petclinic.model.Occupation;
import org.springframework.data.repository.CrudRepository;

public interface OccupationRepository extends CrudRepository<Occupation, Short> {

}
