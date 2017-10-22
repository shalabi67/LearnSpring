package com.learn.configuration.schoolframework.configurations;

import com.learn.configuration.schoolframework.data.School;
import com.learn.configuration.schoolframework.services.ISchoolService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Created by mohammad on 10/22/2017.
 */
@Configuration
public class SchoolConfiguration {
    @Bean
    @ConditionalOnMissingBean(name = {"schoolService"})
    public ISchoolService schoolService() {
        return new ISchoolService() {
            @Override
            public List<School> getSchools() {
                List<School> schools = new ArrayList<>();
                return schools;
            }
        };
    }
}
