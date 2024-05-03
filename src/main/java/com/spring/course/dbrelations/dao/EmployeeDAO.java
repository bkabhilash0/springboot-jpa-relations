package com.spring.course.dbrelations.dao;

import com.spring.course.dbrelations.entity.Employee;
import com.spring.course.dbrelations.entity.EmployeeDetails;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    void createEmployee(Employee employee);

    Employee findById(Integer id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    EmployeeDetails findEmployeeDetails(Integer id);

    Employee getEmployeeWithProjects(Integer id);
}
