package com.learn.repository;

import com.learn.RedisConfig;
import com.learn.RedisRepositoryConfig;
import com.learn.TestConfiguration;
import com.learn.model.Address;
import com.learn.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by mshalabi on 10.08.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class, RedisConfig.class, RedisRepositoryConfig.class})
public class FindingEmployees {
    private static final String  MOHAMMAD = "mohammad";
    @Autowired
    private EmployeeRepository employeeRepository;

    private Address address = new Address("löwneberger str. 10", "45980", "redmond", "germany");
    private Address address1 = new Address("löwneberger str. 10", "10111", "redmond", "germany");

    private static Integer COUNTER = 0;
    private static int INITCOUNTER = 0;
    @Before
    public void iniTest() {
        ++INITCOUNTER;
        Employee employee = createEmployee(address);
        employee = employeeRepository.save(employee);


        Employee nextEmployee = createEmployee(address1);
        nextEmployee = employeeRepository.save(nextEmployee);


        employee = createEmployee(address);
        employee = employeeRepository.save(employee);
    }
    @Test
    public void findingEmployeeByZip() {
        List<Employee> employees = employeeRepository.findEmployeesByAddress_Zip(address.getZip());

        Assert.assertTrue(employees.size() == COUNTER - INITCOUNTER);
    }

    @Test
    public void findingEmployeeByFirstName() {
        List<Employee> employees = employeeRepository.findEmployeesByFirstName(MOHAMMAD);

        Assert.assertTrue(employees.size() == COUNTER - INITCOUNTER);
    }

    private Employee createEmployee(Address address) {
        ++COUNTER;
        Employee employee = new Employee(COUNTER, (COUNTER%2)==0?MOHAMMAD: "wrong", "shalabi");
        employee.setAddress(address);

        return employee;
    }
}
