package com.learn.configuration.democlassconfiguration.configurations;

import com.learn.configuration.schoolframework.data.School;
import com.learn.configuration.schoolframework.services.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad on 10/22/2017.
 */
@Configuration
public class DemoSchoolConfiguration {
    //@Bean
    public ISchoolService schoolService() {
        return new ISchoolService() {
            @Override
            public List<School> getSchools() {
                List<School> schools = new ArrayList<>();
                schools.add(new School("school 1"));
                schools.add(new School("school 2"));
                schools.add(new School("school 3"));
                return schools;
            }
        };
    }



}
