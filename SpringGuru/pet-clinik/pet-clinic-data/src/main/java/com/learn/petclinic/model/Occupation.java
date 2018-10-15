package com.learn.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="occupations")
public class Occupation extends BaseModel<Short> {
	public static final String owner = "owner";
	public static final String vet = "vet";

	private String name;

}
