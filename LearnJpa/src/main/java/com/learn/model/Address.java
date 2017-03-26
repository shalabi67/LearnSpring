package com.learn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Address {
	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long addressId;
	
	@JsonView(View.Summary.class)
	String street;
	
	@JsonView(View.Summary.class)
	String city;
	
	@JsonView(View.Summary.class)
	String postCode;
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
}
