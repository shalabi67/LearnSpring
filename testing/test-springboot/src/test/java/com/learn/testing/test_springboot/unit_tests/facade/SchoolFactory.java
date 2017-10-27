package com.learn.testing.test_springboot.unit_tests.facade;

import com.learn.testing.test_springboot.data.School;

public class SchoolFactory {
    public static School createValidSchool() {
        return createSchool("valid school", "12345");
    }
    public static School createSchool(String schoolName, String zipCode) {
        School school = new School();
        school.setSchoolName(schoolName);
        school.setZipCode(zipCode);

        return school;
    }
}
