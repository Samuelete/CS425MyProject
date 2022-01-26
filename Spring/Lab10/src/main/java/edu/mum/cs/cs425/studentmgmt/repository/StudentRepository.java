package edu.mum.cs.cs425.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import edu.mum.cs.cs425.studentmgmt.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
