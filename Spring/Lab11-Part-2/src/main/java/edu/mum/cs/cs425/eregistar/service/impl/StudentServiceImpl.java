package edu.mum.cs.cs425.eregistar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs.cs425.eregistar.model.Student;
import edu.mum.cs.cs425.eregistar.repository.StudentRepository;
import edu.mum.cs.cs425.eregistar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
		
	}

	@Override
	public List<Student> searchStudents(String searchStudents) {
		return studentRepository.findAllByFirstNameOrLastName(searchStudents, searchStudents);
	}
	
}
