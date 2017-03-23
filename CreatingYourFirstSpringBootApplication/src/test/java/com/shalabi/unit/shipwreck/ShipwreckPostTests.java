package com.shalabi.unit.shipwreck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.shalabi.repository.ShipwreckRepository;
import com.shalabi.unit.config.ShipwreckConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShipwreckConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ShipwreckPostTests {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@Test
	public void test() {
		shipwreckRepository.findAll();
	}
}
