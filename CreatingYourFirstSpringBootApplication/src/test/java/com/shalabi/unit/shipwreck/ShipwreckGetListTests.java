package com.shalabi.unit.shipwreck;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shalabi.controller.ShipwreckController;
import com.shalabi.model.Shipwreck;
import com.shalabi.repository.ShipwreckRepository;

public class ShipwreckGetListTests {
	
	@InjectMocks	
	private ShipwreckController shipwreckController;
	
	
	@Mock
	private ShipwreckRepository shipwreckRerpository;

	@Test
	public void getValidShipwreckList() {
		when(shipwreckRerpository.findAll()).thenReturn(Collections.emptyList());
		List<Shipwreck> shipWrecks = shipwreckController.getShipwerckList();
		
	}
	
	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
	}

}
