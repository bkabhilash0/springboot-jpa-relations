package com.spring.course.dbrelations;

import com.spring.course.dbrelations.dao.EmployeeDAO;
import com.spring.course.dbrelations.dao.EmployeeDAOImpl;
import com.spring.course.dbrelations.dao.ProjectDAO;
import com.spring.course.dbrelations.entity.Employee;
import com.spring.course.dbrelations.entity.EmployeeDetails;
import com.spring.course.dbrelations.entity.Project;
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
    public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO, ProjectDAO projectDAO) {
        return runner -> {
            System.out.println("Hello World");
//            getAllEmployees(employeeDAO);
//            createEmployee(employeeDAO);
//            findEmployee(employeeDAO);
//            updateEmployee(employeeDAO);
//            deleteEmployee(employeeDAO);
//            getEmployeeDetails(employeeDAO);

//            getAllProjects(projectDAO);
//            getProjectsOfAnEmployee(employeeDAO,projectDAO);
            getEmployeeWithProjectsLazy(employeeDAO);
        };
    }

    private void getEmployeeWithProjectsLazy(EmployeeDAO employeeDAO) {
        Employee employee = employeeDAO.getEmployeeWithProjects(1);
        System.out.println(employee);
        System.out.println(employee.getEmployeeDetails());
        employee.getProjects().forEach(System.out::println);
    }

    private void getProjectsOfAnEmployee(EmployeeDAO employeeDAO,ProjectDAO projectDAO) {
        Employee employee = employeeDAO.findById(1);
        System.out.println(employee);
        List<Project> projects = projectDAO.getProjectsByEmployeeId(employee.getId());
        employee.setProjects(projects);
        employee.getProjects().forEach(System.out::println);
    }

    private void getAllProjects(ProjectDAO projectDAO) {
        List<Project> projects = projectDAO.getAllProjects();
        projects.forEach(System.out::println);
//        System.out.println(projects);
    }

    private void getEmployeeDetails(EmployeeDAO employeeDAO) {
        EmployeeDetails employeeDetails = employeeDAO.findEmployeeDetails(1);
        System.out.println(employeeDetails);
        System.out.println(employeeDetails.getEmployee());
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
