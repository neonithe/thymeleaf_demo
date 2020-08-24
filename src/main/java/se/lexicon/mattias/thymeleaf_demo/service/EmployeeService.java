package se.lexicon.mattias.thymeleaf_demo.service;

import java.util.List;

import se.lexicon.mattias.thymeleaf_demo.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

    List<Employee> sortFirstName();

    List<Employee> sortLastName();

    List<Employee> sortEmail();

}
