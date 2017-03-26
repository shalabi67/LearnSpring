package com.shalabi.unit.shipwreck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shalabi.controller.ShipwreckController;
import com.shalabi.model.Shipwreck;
import com.shalabi.repository.ShipwreckRepository;
import com.shalabi.unit.config.ShipwreckConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShipwreckConfiguration.class)
//, loader = AnnotationConfigContextLoader.class)
public class ShipwreckPostTests {
	@Autowired
	ShipwreckController shipwreckController;

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@Test
	public void testNormalAdd() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setName("test");

		Shipwreck newShipwreck = shipwreckController.createShipwerck(shipwreck);
		
		Shipwreck exitingShipwreck = shipwreckRepository.findOne(shipwreck.getId());
		
		assertThat(exitingShipwreck.getId(), is(newShipwreck.getId()));
		
		
	}
}
