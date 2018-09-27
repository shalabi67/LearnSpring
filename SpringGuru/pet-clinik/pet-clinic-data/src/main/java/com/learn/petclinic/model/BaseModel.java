package com.learn.petclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseModel<ID> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected ID id;

	public ID getId() {
		return id;
	}
}
