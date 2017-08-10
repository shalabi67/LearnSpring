package com.learn.repository;

import com.learn.RedisApplication;
import com.learn.RedisConfig;
import com.learn.TestConfiguration;
import com.learn.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mshalabi on 10.08.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class, RedisConfig.class})
public class AddingPerson {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRepositoryAutoId personRepositoryAutoId;

    @Test
    public void addingNewPerson() {
        Person person = new Person(10, "mohammad", "shalabi");
        personRepository.save(person);

        Person person1 = personRepository.find(person.getId());

        Assert.assertEquals(person, person1);
    }

    @Test
    public void addingNewPersonWithoutId() {
        Person person = new Person(-1,"mohammad", "shalabi");
        person = personRepositoryAutoId.save(person);

        Person person1 = personRepository.find(person.getId());

        Assert.assertEquals(person, person1);
    }


}
