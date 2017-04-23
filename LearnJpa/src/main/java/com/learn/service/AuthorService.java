package com.learn.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.model.Author;
import com.learn.model.Book;

@Service
public interface AuthorService {
	
	public List<Author> getAuthors();
	
	public ResponseEntity<Author> addAuthor(Author author);
	
	public ResponseEntity<String> updateAuthor(Author author);
	
	public ResponseEntity<Author> getAuthor(Long authorId);
	
	public ResponseEntity<Set<Book>>  getAuthorBooks(Long authorId);

	public List<Author> getAuthors(Pageable page);
}
