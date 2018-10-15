package com.learn.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Setter
@Getter
@MappedSuperclass
public class BaseModel<ID> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected ID id;

}
