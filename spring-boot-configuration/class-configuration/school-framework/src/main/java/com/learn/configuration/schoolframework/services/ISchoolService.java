package com.learn.configuration.schoolframework.services;

import com.learn.configuration.schoolframework.data.School;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mohammad on 10/22/2017.
 */
@Service
public interface ISchoolService {
    List<School> getSchools();
}
