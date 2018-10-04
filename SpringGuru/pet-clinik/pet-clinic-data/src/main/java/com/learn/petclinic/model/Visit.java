package com.learn.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Visit extends BaseModel<Long>{
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


}
