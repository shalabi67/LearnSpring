package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.Author;
import com.learn.service.AuthorService;

@RestController
@RequestMapping(PathsConstants.authors)
public class AuthorController {
	@Autowired
	AuthorService authorService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Author>> getAuthors() {
		List<Author> authors = authorService.getAuthors();
		if(authors.isEmpty()) {
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		if(author == null) {
			return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			Author newAuthor = authorService.addAuthor(author);
			return new ResponseEntity<Author>(newAuthor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Author>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}
