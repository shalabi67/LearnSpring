package com.learn.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Pet extends BaseModel<Long>{
	@OneToOne
	private PetType petType;
	@OneToOne
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
