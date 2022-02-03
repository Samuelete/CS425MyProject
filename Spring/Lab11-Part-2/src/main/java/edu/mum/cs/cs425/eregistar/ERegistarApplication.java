package edu.mum.cs.cs425.eregistar;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.eregistar.model.Student;
import edu.mum.cs.cs425.eregistar.service.StudentService;

@SpringBootApplication
public class ERegistarApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	public ERegistarApplication(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ERegistarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
System.out.println("Student Application Starting");
		
		var student1 = new Student("000-12-0003", "Samuel", null, "Bartolome", 3.98, LocalDate.of(2022, 1, 1),"Yes");
		var student2 = new Student("000-11-0010", "Jorge", null, "Marta", 3.98, LocalDate.of(2012, 12, 12), "Yes");
		Student s1 = new Student(4, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2002, 5, 29), "Yes");
		
		studentService.saveStudent(student1);
		studentService.saveStudent(student2);
		studentService.saveStudent(s1);
		
		System.out.println("Student App completed ... GoodBye");
		
	}
	
	

}
