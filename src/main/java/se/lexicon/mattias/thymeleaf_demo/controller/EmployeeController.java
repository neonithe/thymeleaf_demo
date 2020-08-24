package se.lexicon.mattias.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.mattias.thymeleaf_demo.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //Load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        // create employee
        Employee emp1 = new Employee(1,"Test1", "Test1", "Test1");
        Employee emp2 = new Employee(2,"Test2", "Test2", "Test2");
        Employee emp3 = new Employee(3,"Test3", "Test3", "Test3");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    //add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }

}
