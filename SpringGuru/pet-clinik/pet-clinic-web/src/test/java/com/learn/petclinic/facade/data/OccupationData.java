package com.learn.petclinic.facade.data;

import com.learn.petclinic.model.Occupation;

public class OccupationData {


	public static Occupation create(Short id, String occupationName) {
		Occupation occupation = new Occupation(occupationName);
		occupation.setId(id);

		return  occupation;
	}

	public static Occupation[] occupations = {
			OccupationData.create((short)1, "occ"),
			OccupationData.create((short)2, "occ1")
	};

}
