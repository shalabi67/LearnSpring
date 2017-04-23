package com.shalabi.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shalabi.model.Shipwreck;
import com.shalabi.repository.ShipwreckRepository;



@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> getShipwerckList() {
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public Shipwreck createShipwerck(@RequestBody Shipwreck shipwreck) {
		shipwreck = shipwreckRepository.saveAndFlush(shipwreck);
		return shipwreck;		
	}
	
	@RequestMapping(value="shipwrecks/{shipwreckId}", method=RequestMethod.GET)
	public Shipwreck getShipwerck(@PathVariable Long shipwreckId) {
		Shipwreck shipwreck = shipwreckRepository.findOne(shipwreckId);
		return shipwreck;	
	}
	
	@RequestMapping(value="shipwrecks/{shipwreckId}", method=RequestMethod.PUT)
	public Shipwreck updateShipwerck(@PathVariable Long shipwreckId, @RequestBody Shipwreck shipwreck) {
		Shipwreck dbShipwreck = shipwreckRepository.findOne(shipwreckId);
		BeanUtils.copyProperties(shipwreck, dbShipwreck);
		return shipwreckRepository.saveAndFlush(shipwreck);	
	}
	
	@RequestMapping(value="shipwrecks/{shipwreckId}", method=RequestMethod.DELETE)
	public Shipwreck deleteShipwerck(@PathVariable Long shipwreckId) {
		Shipwreck shipwreck = shipwreckRepository.findOne(shipwreckId);
		shipwreckRepository.delete(shipwreckId);
		
		return shipwreck;
	}
	
}
