package com.learn.testing.test_springboot.integration_tests.services;

import com.learn.testing.test_springboot.data.School;
import com.learn.testing.test_springboot.services.SchoolService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddSchoolTesting {
    @Autowired
    SchoolService schoolService;

    @Test
    public void testValidAdd() {
        School school = new School();
        school.setSchoolName("My School");
        School newSchool = schoolService.addSchool(school);

        List<School> schools = schoolService.getSchools();
        Assert.assertEquals(1, schools.size());



    }
}
