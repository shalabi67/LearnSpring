package com.learn.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name="pets")
public class Pet extends BaseModel<Long>{
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="pet_type_id")
	private PetType petType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();

	@ManyToOne
	@JoinColumn(name="person_id")
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

}
