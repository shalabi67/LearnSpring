package com.learn.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name="visits")
public class Visit extends BaseModel<Long>{
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;
	private String description;

	public Visit() {

	}
	public Visit(Pet pet, LocalDate visitDate, String description) {
		this.pet = pet;
		this.visitDate = visitDate;
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public String getDescription() {
		return description;
	}
}
