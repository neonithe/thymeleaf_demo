package se.lexicon.mattias.thymeleaf_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.mattias.thymeleaf_demo.dao.EmployeeRepository;
import se.lexicon.mattias.thymeleaf_demo.entity.Employee;

@SpringBootApplication
public class ThymeleafDemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository dao;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.save(new Employee("Test1","Test1","Test1"));
		dao.save(new Employee("Test2","Test2","Test2"));
		dao.save(new Employee("Test3","Test3","Test3"));
		dao.save(new Employee("Test4","Test4","Test4"));
		dao.save(new Employee("Test5","Test5","Test5"));
		//dao.findAllByOrOrderByLastNameAsc();
		System.out.println(dao.findById(1));
	}

}
