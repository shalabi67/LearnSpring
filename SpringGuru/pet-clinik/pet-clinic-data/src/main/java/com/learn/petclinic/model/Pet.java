package com.learn.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseModel<Long>{
	private PetType petType;
	private Person owner;
	private LocalDate birthDate;

	public Pet(PetType petType, Person owner, LocalDate birthDate) {
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}

	public PetType getPetType() {
		return petType;
	}

	public Person getOwner() {
		return owner;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
}
