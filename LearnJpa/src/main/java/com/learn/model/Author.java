package com.learn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Author extends BasicEntity {
	@JsonView({View.Summary.class, View.NoAddress.class})
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long authorId;

	@JsonView({View.Summary.class, View.NoAddress.class})
	private String firstName;

	@JsonView({View.Summary.class, View.NoAddress.class})
	private String lastName;
	
	@OneToOne
	@JsonView(View.Summary.class)
	private Address address;
	
	@JsonView(View.Summary.class)
	@OneToMany(mappedBy="author", cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<>();
	
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	

}
