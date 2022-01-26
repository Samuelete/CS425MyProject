package edu.mum.cs.cs425.studentmgmt.service;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;

public interface ClassroomService {
	public abstract Classroom saveClasstoom(Classroom classroom);
	Classroom getClassroomById(int id);
}
