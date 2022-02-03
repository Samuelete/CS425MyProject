package edu.mum.cs.cs425.eregistar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.mum.cs.cs425.eregistar.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// add a method to sort by last name
	public List<Student> findAllByOrderByLastNameAsc();
	public List<Student> findAllByFirstNameOrLastName(String firstName, String lastName);
}
