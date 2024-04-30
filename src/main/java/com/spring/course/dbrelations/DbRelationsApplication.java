package com.spring.course.dbrelations;

import com.spring.course.dbrelations.dao.EmployeeDAO;
import com.spring.course.dbrelations.dao.EmployeeDAOImpl;
import com.spring.course.dbrelations.entity.Employee;
import com.spring.course.dbrelations.entity.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DbRelationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbRelationsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {
        return runner -> {
            System.out.println("Hello World");
            getAllEmployees(employeeDAO);
//            createEmployee(employeeDAO);
//            findEmployee(employeeDAO);
//            updateEmployee(employeeDAO);
//            deleteEmployee(employeeDAO);
        };
    }

    private void deleteEmployee(EmployeeDAO employeeDAO) {
        System.out.println("Deleting Employee");
        employeeDAO.deleteEmployee(17);
        System.out.println("Employee Deleted with ID "+17);
    }

    private void updateEmployee(EmployeeDAO employeeDAO) {
        Employee employee = employeeDAO.findById(1);
        employee.setEmployeeDetails(new EmployeeDetails("Trivandrum","Developer"));
        System.out.println("Updating Employee...");
        Employee updatedEmployee = employeeDAO.updateEmployee(employee);
        System.out.println("Employee Updated");
        System.out.println(updatedEmployee);
    }

    private void findEmployee(EmployeeDAO employeeDAO) {
        Employee employee = employeeDAO.findById(18);
        System.out.println(employee);
    }

    private void createEmployee(EmployeeDAO employeeDAO) {
        Employee employee = new Employee("Lucifer","Morningstar","lucifer@gmail.com");
        EmployeeDetails details = new EmployeeDetails("Los Angeles","Devil");
        employee.setEmployeeDetails(details);
        System.out.println("Saving employee");
        employeeDAO.createEmployee(employee);
        System.out.println("Employee saved!");
    }

    private void getAllEmployees(EmployeeDAO employeeDAO) {
        employeeDAO.findAll().forEach(System.out::println);
//        List<Employee> employees = employeeDAO.findAll();
//        System.out.println(employees);
    }

}
