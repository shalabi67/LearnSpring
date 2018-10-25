package com.learn.repository;

import com.learn.RedisConfig;
import com.learn.RedisRepositoryConfig;
import com.learn.TestConfiguration;
import com.learn.model.Address;
import com.learn.model.Employee;
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
@ContextConfiguration(classes = {TestConfiguration.class, RedisConfig.class, RedisRepositoryConfig.class})
public class AddingEmployee {
    @Autowired
    private EmployeeRepository employeeRepository;

    private Address address = new Address("löwneberger str. 10", "45980", "redmond", "germany");

    @Test
    public void addingNewEmployee() {
        Employee employee = new Employee(null, "mohammad", "shalabi");
        employee.setAddress(address);
        employee = employeeRepository.save(employee);

        Employee employee1 = employeeRepository.findOne(employee.getId());


        Assert.assertEquals(employee, employee1);
    }
}
