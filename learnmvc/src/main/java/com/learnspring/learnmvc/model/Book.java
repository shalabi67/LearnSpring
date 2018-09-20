package com.learnspring.learnmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String title;
	protected String isbn;

	@OneToOne
	protected Publisher publisher;

	@ManyToMany
	@JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name="author_id"))
	protected Set<Author> authors = new HashSet<>();

	public static Book create(String title, String isbn, Publisher publisher) {
		Book book = new Book();
		book.title = title;
		book.publisher = publisher;
		book.isbn = isbn;

		return book;
	}

	public static Book create(String title, String isbn, Publisher publisher, Set<Author> authors) {
		Book book = create(title, isbn, publisher, authors);
		book.authors = authors;

		return book;
	}

	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Book book = (Book) o;

		return id != null ? id.equals(book.id) : book.id == null;
	}

	@Override public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
