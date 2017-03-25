package com.learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.model.Author;

@Service
public interface AuthorService {
	
	public List<Author> getAuthors();
	
	public Author addAuthor(Author author);
}
