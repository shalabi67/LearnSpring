package com.learn.petclinic.facade.data;

import com.learn.petclinic.model.Occupation;
import com.learn.petclinic.model.Person;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PersonsData {
	public static Person[] getOwners() {
		return owners;
	}
	public static Person[] getVets() {
		return vets;
	}
	public static Set<Person> getOwnersSet() {
		return new HashSet<Person>(Arrays.asList(getOwners()));
	}
	public static Set<Person> getVetsSet() {
		return new HashSet<Person>(Arrays.asList(getVets()));
	}
	private static Occupation occupation = OccupationData.occupations[0];
	private static Person[] owners = {
			Person.create(1L, "owner1", "last", "address", "city", "phone", occupation),
			Person.create(3L, "owner2", "last", "address", "city", "phone", occupation),
			Person.create(5L, "owner3", "last", "address", "city", "phone", occupation)

	};
	private static Person[] vets = {
			Person.create(2L, "vet1", "last", "address", "city", "phone", occupation),
			Person.create(4L, "vet2", "last", "address", "city", "phone", occupation)

	};
}
