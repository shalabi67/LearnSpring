package com.learn.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.model.Author;
import com.learn.model.Book;
import com.learn.model.View;
import com.learn.service.AuthorService;

@RestController
@RequestMapping(PathsConstants.authors)
public class AuthorController {
	//http://localhost:9099/api/authors
	@Autowired
	AuthorService authorService;
	@JsonView(View.NoAddress.class)
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Author>> getAuthors(Pageable page) {  //?page=0&size=3
		List<Author> authors = authorService.getAuthors(page);
		
		if(authors.isEmpty()) {
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
		
	}

	//http://localhost:9099/api/authors/find?first_name=moh&post_code=10315
	@JsonView(View.Summary.class)
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ResponseEntity<List<Author>> getAuthorsBy(
			@RequestParam("first_name") String firstName,
			@RequestParam("post_code") String postCode) {  //?fist_name=moh&post_code=10315
		List<Author> authors = authorService.getAuthors(firstName, postCode);

		if(authors.isEmpty()) {
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);

	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public ResponseEntity<String> updateAuthor(@RequestBody Author author) {
		return authorService.updateAuthor(author);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(value=PathsConstants.authorId, method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId) {
		return authorService.getAuthor(authorId);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(value=PathsConstants.authorBooks, method=RequestMethod.GET)
	public ResponseEntity<Set<Book>> getAuthorBooks(@PathVariable Long authorId) {
		return authorService.getAuthorBooks(authorId);
	}
}
