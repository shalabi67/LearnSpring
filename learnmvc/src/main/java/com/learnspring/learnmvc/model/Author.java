package com.learnspring.learnmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String firstName;
	protected String lastName;
	@ManyToMany(mappedBy = "authors")
	protected Set<Book> books = new HashSet<>();

	public static Author create(String firstName, String lastName) {
		Author author = new Author();
		author.firstName = firstName;
		author.lastName = lastName;

		return author;
	}

	public static Author create(String firstName, String lastName, Set<Book> books) {
		Author author = create(firstName, lastName);
		author.books = books;

		return author;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Author author = (Author) o;

		return id != null ? id.equals(author.id) : author.id == null;
	}

	@Override public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
