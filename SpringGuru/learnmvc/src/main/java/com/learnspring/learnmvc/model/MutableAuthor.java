package com.learnspring.learnmvc.model;

import javax.persistence.Entity;
import java.util.Set;

public class MutableAuthor extends Author {

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
