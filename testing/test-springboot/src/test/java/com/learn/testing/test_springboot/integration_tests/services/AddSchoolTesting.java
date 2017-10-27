package com.learn.testing.test_springboot.integration_tests.services;

import com.learn.testing.test_springboot.data.School;
import com.learn.testing.test_springboot.integration_tests.framework.BaseDatabaseTesting;
import com.learn.testing.test_springboot.integration_tests.framework.BaseTesting;
import com.learn.testing.test_springboot.services.SchoolService;
import com.learn.testing.test_springboot.testsing_data.SchoolsServiceAddingData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


public class AddSchoolTesting extends BaseDatabaseTesting {
    @Autowired
    SchoolService schoolService;

    @Test
    public void testValidAdd() {
        List<School> oldSchools = schoolService.getSchools();
        SchoolsServiceAddingData schoolsServiceAddingData = SchoolsServiceAddingData.createFirstValidSchoolData();
        School newSchool = schoolService.addSchool(schoolsServiceAddingData.schoolToAdd);

        List<School> schools = schoolService.getSchools();
        Assert.assertEquals(1, schools.size() - oldSchools.size());



    }
}
