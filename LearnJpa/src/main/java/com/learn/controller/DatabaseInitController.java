package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.Address;
import com.learn.model.Author;
import com.learn.repository.AddressRepository;
import com.learn.repository.AuthorRepository;

@RestController
@RequestMapping(PathsConstants.init)
public class DatabaseInitController {
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<String> initDatabase() {
		Address address = createAddress("aaaa", "berlin", "10315");
		Address address1 = createAddress("bbbbb", "amman", "98051");
		
		createAuthor("Mohammad", "Shalabi", address);
		createAuthor("Elham", "Shalabi", address1);
		
		return new ResponseEntity<String>("Database Initialized", HttpStatus.OK);
	}
	
	private Author createAuthor(String firstName, String lastName, Address address) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setAddress(address);
		
		
		
		return authorRepository.saveAndFlush(author);
	}
	
	private Address createAddress(String street, String city, String postCode) {
		Address address = new Address();
		address.setCity(city);
		address.setStreet(street);
		address.setPostCode(postCode);
		
		
		
		return addressRepository.saveAndFlush(address);
	}
}
