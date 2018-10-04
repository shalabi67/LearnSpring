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
	private String name;

	public Pet(PetType petType, Person owner, LocalDate birthDate, String name) {
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
		this.name = name;

		owner.getPets().add(this);
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

	public String getName() {
		return name;
	}
}
