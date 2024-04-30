package com.spring.course.dbrelations.dao;

import com.spring.course.dbrelations.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return this.entityManager.createQuery("FROM Employee",Employee.class).getResultList();
    }

    @Transactional
    @Override
    public void createEmployee(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
