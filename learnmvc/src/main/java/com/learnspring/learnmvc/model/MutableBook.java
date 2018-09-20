package com.learnspring.learnmvc.model;

import javax.persistence.Entity;
import java.util.Set;


public class MutableBook extends Book{
	public void setTitle(String title) {
		this.title = title;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
