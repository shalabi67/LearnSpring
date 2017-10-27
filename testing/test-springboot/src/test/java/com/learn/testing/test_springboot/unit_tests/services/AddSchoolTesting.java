package com.learn.testing.test_springboot.unit_tests.services;

import com.learn.testing.test_springboot.data.School;
import com.learn.testing.test_springboot.repository.SchoolsRepository;
import com.learn.testing.test_springboot.services.SchoolService;
import com.learn.testing.test_springboot.testsing_data.SchoolsServiceAddingData;
import com.learn.testing.test_springboot.unit_tests.facade.SchoolFactory;
import com.learn.testing.test_springboot.unit_tests.facade.SchoolRepositoryMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AddSchoolTesting {
    @InjectMocks
    SchoolService schoolService;

    @Mock
    SchoolsRepository schoolsRepository;

    @Test
    public void testValidAdd() {

        SchoolsServiceAddingData schoolsServiceAddingData = SchoolsServiceAddingData.createFirstValidSchoolData();
        SchoolRepositoryMock.initSchoolRepositoryAddingSchoolsMock(schoolsRepository, schoolsServiceAddingData);

        School newSchool = schoolService.addSchool(schoolsServiceAddingData.schoolToAdd);
        List<School> schools = schoolService.getSchools();
        Assert.assertEquals(1, schools.size());

    }
}
