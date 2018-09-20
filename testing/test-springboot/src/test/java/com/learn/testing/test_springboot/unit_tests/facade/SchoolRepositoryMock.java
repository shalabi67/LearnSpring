package com.learn.testing.test_springboot.unit_tests.facade;

import com.learn.testing.test_springboot.data.School;
import com.learn.testing.test_springboot.repository.SchoolsRepository;
import com.learn.testing.test_springboot.testsing_data.SchoolsServiceAddingData;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

public class SchoolRepositoryMock {


    public static void initSchoolRepositoryAddingSchoolsMock(SchoolsRepository schoolsRepository, SchoolsServiceAddingData data) {
        School school = data.schoolToAdd;
        List<School> schools = data.exitingSchools;
        if(school == null) {
            Mockito.when(schoolsRepository.saveAndFlush(data.schoolToAdd)).thenReturn(null);
        }
        else if(school.getSchoolName() == null) {
            Mockito.when(schoolsRepository.saveAndFlush(data.schoolToAdd)).thenReturn(null);
        }
        else {
            school.setSchoolId(data.expectedId);
            Mockito.when(schoolsRepository.saveAndFlush(data.schoolToAdd)).thenReturn(school);
            schools.add(school);
        }


        if(schools == null) {
            Mockito.when(schoolsRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        }
        else {
            Mockito.when(schoolsRepository.findAll()).thenReturn(schools);
        }

    }

}
