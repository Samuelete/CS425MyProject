package edu.mum.cs.cs425.studentmgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Override
	public Classroom saveClasstoom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	@Override
	public Classroom getClassroomById(int id) {
		return classroomRepository.findById(id).orElse(null);
	}

}
