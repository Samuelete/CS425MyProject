package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.service.ClassroomService;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;
import edu.mum.cs.cs425.studentmgmt.service.TranscriptService;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TranscriptService transcriptService;
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	public MyStudentMgmtApp(StudentService studentService, TranscriptService transcriptService, ClassroomService classroomService) {
		super();
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.classroomService = classroomService;
	}


	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Student Application Starting");
		
		var student1 = new Student("000-12-0003", "Samuel", null, "Bartolome", 3.98, LocalDate.of(2022, 1, 1),null,null);
		var student2 = new Student("000-11-0010", "Jorge", null, "Marta", 3.98, LocalDate.of(2012, 12, 12),null,null);
		Student s1 = new Student(4, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2002, 5, 29),null,null);
		
		Transcript transcript1 = new Transcript("BS Computer Science",null);
		Transcript transcript2 = new Transcript("BS Mathematics",null);
		Transcript transcript3 = new Transcript("BS Physics",null);
		
		student1.setTranscript(transcript1);
		student2.setTranscript(transcript2);
		s1.setTranscript(transcript3);
		
//		transcript1.setStudent(student1);
//		transcript2.setStudent(student2);
//		transcript3.setStudent(s1);
		
//		List<Student> students = List.of(student1, student2, s1);
		Classroom clasroom = new Classroom("McLaughlin building", "M105");
		
//		student1.setClassroom(clasroom);
//		student2.setClassroom(clasroom);
//		s1.setClassroom(clasroom);
		
		
		var savedStudent1 = studentService.saveStudent(student1);
		var savedStudent2 = studentService.saveStudent(student2);
		var savedStudent3 = studentService.saveStudent(s1);
		
		List<Student> savedStudents = List.of(savedStudent1, savedStudent2, savedStudent3);
		
//		transcriptService.saveTranscript(transcript1);
//		transcriptService.saveTranscript(transcript2);
//		transcriptService.saveTranscript(transcript3);
		clasroom.setStudents(savedStudents);
		classroomService.saveClasstoom(clasroom);
		
		System.out.println("Student App completed ... GoodBye");
		
	}

}
