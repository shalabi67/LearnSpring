package com.learn.repository;

import com.learn.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by mshalabi on 10.08.17.
 */
@Component
public class PersonRepositoryAutoId {
    private static final String KEY = "person";
    private static final String ID = KEY + ":id";


    @Resource(name="redisTemplate")
    private ValueOperations<String, Object> stringValueOperations;


    /*
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    */

    public Person save(final Person person) {
        incrementId();
        int id = getId();
        person.setId(id);
        String key = getKey(person);
        stringValueOperations.set(key, person);
        //redisTemplate.opsForValue().set(key, person);

        return person;
    }

    public Person find(int personId) {
        String key = getKey(personId);
        return (Person)stringValueOperations.get(key);
    }

    private String getKey(final Person person) {
        return getKey(person.getId());
    }
    private String getKey(int id) {
        return KEY + ":" + id;
    }

    private int getId() {
        return (Integer)stringValueOperations.get(ID);
    }
    private void incrementId() {
        stringValueOperations.increment(ID, 1);
    }
}
