package com.learnspring.learnmvc.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected String name;

	public static Publisher create(String name) {
		Publisher publisher = new Publisher();
		publisher.name = name;

		return publisher;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
