package com.learn.testing.test_springboot.services;


import com.learn.testing.test_springboot.data.School;
import com.learn.testing.test_springboot.repository.SchoolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolsRepository schoolsRepository;

    public School addSchool(School school) {
        School newSchool = schoolsRepository.saveAndFlush(school);
        return newSchool;
    }

    public List<School> getSchools() {
        return schoolsRepository.findAll();
    }


}
