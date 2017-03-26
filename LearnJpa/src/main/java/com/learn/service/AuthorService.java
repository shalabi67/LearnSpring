package com.learn.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.model.Author;

@Service
public interface AuthorService {
	
	public List<Author> getAuthors();
	
	public ResponseEntity<Author> addAuthor(Author author);
	
	public ResponseEntity<String> updateAuthor(Author author);
}
