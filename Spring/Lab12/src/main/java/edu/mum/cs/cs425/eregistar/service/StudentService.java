package edu.mum.cs.cs425.eregistar.service;

import java.util.List;

import edu.mum.cs.cs425.eregistar.model.Student;

public interface StudentService {

	public abstract Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(Integer id);
	public void deleteById(int theId);
	public abstract List<Student> searchStudents(String searchStudents);
	Student updateStudentById(Student updatedStudent, Integer studentId);
}
