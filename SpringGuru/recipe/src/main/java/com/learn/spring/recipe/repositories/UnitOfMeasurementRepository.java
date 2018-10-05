package com.learn.spring.recipe.repositories;

import com.learn.spring.recipe.models.UnitOfMeasurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasurementRepository extends CrudRepository<UnitOfMeasurement, Short>{

}
