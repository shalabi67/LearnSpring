package com.learn.configuration.schoolframework.controllers;

import com.learn.configuration.schoolframework.data.School;
import com.learn.configuration.schoolframework.services.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mohammad on 10/22/2017.
 */
@RestController
public class SchoolController {
    @Autowired
    ISchoolService schoolService;

    @RequestMapping("/schools")
    public List<School> getSchools() {
        return schoolService.getSchools();
    }
}
