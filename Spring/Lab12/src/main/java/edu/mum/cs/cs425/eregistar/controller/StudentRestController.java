package edu.mum.cs.cs425.eregistar.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import edu.mum.cs.cs425.eregistar.model.Student;
import edu.mum.cs.cs425.eregistar.service.StudentService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:8080"}, allowedHeaders = "*")
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRestController {

	private StudentService studentService;
	
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(value = "/list")
	public List<Student> listStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping(value = "/register")
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping(value = "/get/{studentId}")
	public Student getStudentById(@PathVariable Integer studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@PutMapping(value = "/update/{studentId}")
	public Student updateStudentById(@Valid @RequestBody Student updatedStudent,
			@PathVariable Integer studentId) {
		return studentService.updateStudentById(updatedStudent, studentId);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public void deleteStudent(@PathVariable Integer studentId) {
		studentService.deleteById(studentId);	
	}
	
}
