package com.learn.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.model.Author;
import com.learn.repository.AuthorRepository;

@Service
public class AuthorServiceImp implements AuthorService {
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public ResponseEntity<Author> addAuthor(Author author) {
		if(author == null) {
			return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
		}
				
		try {
			author.setBooks(Collections.emptySet());
			author.setAddress(null);
			Author newAuthor = authorRepository.saveAndFlush(author);
			return new ResponseEntity<Author>(newAuthor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Author>(HttpStatus.EXPECTATION_FAILED);
		}		
	}

	@Override
	public ResponseEntity<String> updateAuthor(Author author) {
		if(author == null || author.getAuthorId() == null) {
			return new ResponseEntity<String>("Author is not provided or no author id", HttpStatus.BAD_REQUEST);
		}
		
		if(authorRepository.findOne(author.getAuthorId()) == null) {
			return new ResponseEntity<String>("Author not exist", HttpStatus.NOT_FOUND);
		}
		
		authorRepository.saveAndFlush(author);
		return new ResponseEntity<String>("Author updated succesfully", HttpStatus.OK);
	}
	
}
