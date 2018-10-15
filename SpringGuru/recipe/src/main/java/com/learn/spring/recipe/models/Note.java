package com.learn.spring.recipe.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Getter
@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@OneToOne
	protected Recipe recipe;
	@Lob
	protected String recipeNote;

	public Note() {

	}
	public Note(String recipeNote) {
		this.recipeNote = recipeNote;
	}

}
