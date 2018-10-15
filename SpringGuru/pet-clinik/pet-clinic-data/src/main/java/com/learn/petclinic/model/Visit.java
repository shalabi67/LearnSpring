package com.learn.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Getter
@NoArgsConstructor
@Entity
@Table(name="visits")
public class Visit extends BaseModel<Long>{
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;
	private String description;

	public Visit(Pet pet, LocalDate visitDate, String description) {
		this.pet = pet;
		pet.getVisits().add(this);
		this.visitDate = visitDate;
		this.description = description;
	}

}
