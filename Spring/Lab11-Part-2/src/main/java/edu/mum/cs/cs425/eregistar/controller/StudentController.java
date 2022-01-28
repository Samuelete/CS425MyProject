package edu.mum.cs.cs425.eregistar.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.mum.cs.cs425.eregistar.model.Student;
import edu.mum.cs.cs425.eregistar.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}


	@GetMapping("/list")
	public String listStudents(Model model) {
		
		List<Student> students = studentService.getAllStudents();
		
		model.addAttribute("students", students);
		
		return "students/list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "students/student-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model model) {
		
		Student student = studentService.getStudentById(theId);
		
		model.addAttribute("student", student);
		
		return "students/student-form";			
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);

		return "redirect:/students/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		studentService.deleteById(theId);
		
		return "redirect:/students/list";
		
	}
	
    @GetMapping(value = "/search")
    public ModelAndView searchStudents(@RequestParam String searchStudents) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchStudents);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchStudents", searchStudents);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("students/list-students");
        return modelAndView;
    }

}
