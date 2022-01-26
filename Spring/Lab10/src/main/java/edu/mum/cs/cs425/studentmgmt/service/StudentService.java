package edu.mum.cs.cs425.studentmgmt.service;

import edu.mum.cs.cs425.studentmgmt.model.Student;

public interface StudentService {

	public abstract Student saveStudent(Student student);
	Student getStudentById(Integer id);
	
}
