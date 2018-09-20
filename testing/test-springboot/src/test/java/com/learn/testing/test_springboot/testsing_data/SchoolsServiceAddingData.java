package com.learn.testing.test_springboot.testsing_data;

import com.learn.testing.test_springboot.data.School;
import com.learn.testing.test_springboot.unit_tests.facade.SchoolFactory;

import java.util.ArrayList;
import java.util.List;

public class SchoolsServiceAddingData {
    public List<School> exitingSchools;
    public School schoolToAdd;
    public int expectedId;
    public int getExpectedResult() {
        int count  = exitingSchools.size();
        if(schoolToAdd!=null
                && schoolToAdd.getSchoolName()!=null
                && !schoolToAdd.getSchoolName().isEmpty())
            count++;
        return count;
    }

    public static SchoolsServiceAddingData createFirstValidSchoolData() {
        SchoolsServiceAddingData schoolsServiceAddingData = new SchoolsServiceAddingData();
        schoolsServiceAddingData.exitingSchools = schoolsServiceAddingData.emptySchool;
        schoolsServiceAddingData.schoolToAdd = schoolsServiceAddingData.validSchool;
        schoolsServiceAddingData.expectedId = schoolsServiceAddingData.emptySchool.size() +1;

        return schoolsServiceAddingData;
    }

    private List<School> emptySchool = new ArrayList<>();
    School validSchool = SchoolFactory.createValidSchool();
}
