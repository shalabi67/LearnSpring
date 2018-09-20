package com.learnspring.learnmvc.model;

import java.util.Set;

public class MutablePublisher extends Publisher{
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
