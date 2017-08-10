package com.learn.repository;

import com.learn.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mshalabi on 10.08.17.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
        List<Employee> findEmployeesByAddress_Zip(String zip);
        List<Employee> findEmployeesByFirstName(String firstName);
}