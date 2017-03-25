package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Author addAuthor(Author author) {
		return authorRepository.saveAndFlush(author);
	}
	
}
