package com.learn.spring.recipe.repositories;

import com.learn.spring.recipe.models.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasurementRepository extends CrudRepository<UnitOfMeasurement, Short>{

	Optional<UnitOfMeasurement> findByName(String name);
}
