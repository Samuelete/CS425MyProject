package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;
	
	@Column(name="student_number", unique = true, nullable = false)
	private String studentNumber;
	
	@NotNull
	private String firstName;
	
	private String middleName;
	
	@NotNull
	private String lastName;
	private Double gpa;
	private LocalDate dateOfEnrollment;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="transcript_id", nullable = false, unique = true)
	private Transcript transcript;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = true)
	private Classroom classroom;
	
	public Student() {}

	public Student(@NotNull String studentNumber, @NotNull String firstName, String middleName,
			@NotNull String lastName, Double gpa, LocalDate dateOfEnrollment, Transcript transcript,
			Classroom classroom) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classroom = classroom;
	}
	
	public Student(Integer studentId, @NotNull String studentNumber, @NotNull String firstName, String middleName,
			@NotNull String lastName, Double gpa, LocalDate dateOfEnrollment, Transcript transcript,
			Classroom classroom) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classroom = classroom;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	
	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classroom, dateOfEnrollment, firstName, gpa, lastName, middleName, studentId, studentNumber,
				transcript);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(classroom, other.classroom) && Objects.equals(dateOfEnrollment, other.dateOfEnrollment)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gpa, other.gpa)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(studentId, other.studentId) && Objects.equals(studentNumber, other.studentNumber)
				&& Objects.equals(transcript, other.transcript);
	}

	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, studentNumber=%s, firstName=%s, middleName=%s, lastName=%s, gpa=%s, dateOfEnrollment=%s, transcript=%s, classroom=%s]",
				studentId, studentNumber, firstName, middleName, lastName, gpa, dateOfEnrollment, transcript,
				classroom);
	}	
}
