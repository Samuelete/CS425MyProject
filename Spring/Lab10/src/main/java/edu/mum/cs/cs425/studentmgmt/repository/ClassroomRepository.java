package edu.mum.cs.cs425.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import edu.mum.cs.cs425.studentmgmt.model.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {

}
