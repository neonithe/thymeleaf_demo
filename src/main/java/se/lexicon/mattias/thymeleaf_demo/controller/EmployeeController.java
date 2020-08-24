package se.lexicon.mattias.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.lexicon.mattias.thymeleaf_demo.entity.Employee;
import se.lexicon.mattias.thymeleaf_demo.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping(value="/employees", method = {RequestMethod.GET, RequestMethod.PUT})
public class EmployeeController {

    private EmployeeService employeeService;

    //constructor injection
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // get employees from database
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees.html";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //Create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form.html";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(
            @RequestParam("employeeId")
                    int theId,
                    Model theModel)
    {
        //get the employee from DB
        Employee theEmployee = employeeService.findById(theId);

        //set the employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        //send over to our form
        return "employees/employee-form.html";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("employeeId") int theId){

        //Delete the employee
        employeeService.deleteById(theId);
        //Redirect to /employees/list
        return "redirect:/employees/list";
    }

    @GetMapping("/sortFirstName")
    public String sortEmployees(Model theModel){

        // get employees from database
        List<Employee> theEmployees = employeeService.sortFirstName();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees.html";
    }

    @GetMapping("/sortLastName")
    public String sortEmployeesLast(Model theModel){

        // get employees from database
        List<Employee> theEmployees = employeeService.sortLastName();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees.html";
    }

    @GetMapping("/sortEmail")
    public String sortEmployeesEmail(Model theModel){

        // get employees from database
        List<Employee> theEmployees = employeeService.sortEmail();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees.html";
    }


}
