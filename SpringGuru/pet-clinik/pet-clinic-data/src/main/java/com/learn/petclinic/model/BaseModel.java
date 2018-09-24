package com.learn.petclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
}
