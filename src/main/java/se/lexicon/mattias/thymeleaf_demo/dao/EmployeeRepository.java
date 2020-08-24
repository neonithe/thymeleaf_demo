package se.lexicon.mattias.thymeleaf_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.mattias.thymeleaf_demo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();
    // sort by first name
    List<Employee> findAllByOrderByFirstNameAsc();
    // sort by email
    List<Employee> findAllByOrderByEmailAsc();

}
