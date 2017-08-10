package com.learn;

import com.learn.repository.PersonRepository;
import com.learn.repository.PersonRepositoryAutoId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mshalabi on 10.08.17.
 */
@Configuration
public class TestConfiguration {
    @Bean
    public PersonRepository personRepository() {
        final PersonRepository personRepository = new PersonRepository();

        return personRepository;
    }

    @Bean
    public PersonRepositoryAutoId personRepositoryAutoId() {
        final PersonRepositoryAutoId personRepository = new PersonRepositoryAutoId();

        return personRepository;
    }
}
