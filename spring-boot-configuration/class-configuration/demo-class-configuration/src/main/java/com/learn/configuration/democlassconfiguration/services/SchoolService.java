package com.learn.configuration.democlassconfiguration.services;

import com.learn.configuration.schoolframework.data.School;
import com.learn.configuration.schoolframework.services.ISchoolService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad on 10/22/2017.
 */
@Service
@Profile("production")
public class SchoolService implements ISchoolService {
    @Override
    public List<School> getSchools() {
        List<School> schools = new ArrayList<>();
        schools.add(new School("school 1"));
        schools.add(new School("school 2"));
        schools.add(new School("school 3"));
        return schools;
    }
}
