package com.learn.spring.recipe.repositories;

import com.learn.spring.recipe.models.UnitOfMeasurement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasurementRepositoryIT {

	@Autowired
	UnitOfMeasurementRepository unitOfMeasurementRepository;

	@Before public void setUp() throws Exception {
	}

	@Test public void findByName() throws Exception {
		String unitName = "Tablespoon";
		Optional<UnitOfMeasurement> unitOfMeasure = unitOfMeasurementRepository.findByName(unitName);

		Assert.assertEquals(unitName, unitOfMeasure.get().getName());
	}

}