package edu.mum.cs.cs425.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;

public interface TranscriptRepository extends CrudRepository<Transcript, Integer> {
	
}
