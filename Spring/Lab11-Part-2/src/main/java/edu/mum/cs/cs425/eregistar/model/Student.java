package edu.mum.cs.cs425.eregistar.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;
	
	// required
	@NotBlank(message = "* Student Number is required")
	@Column(name="student_number", unique = true, nullable = false)
	private String studentNumber;
	
	//required
	@NotNull
	@NotBlank(message = "* First Name is required")
	private String firstName;
	
	private String middleName;
	
	// required
	@NotNull
	@NotBlank(message = "* Last Name is required")
	private String lastName;
	private Double gpa;
	// required
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfEnrollment;
	// required
	@NotBlank(message = "* Is International is required")
	private String isInternational;
	

	public Student() {}

	public Student(@NotNull String studentNumber, @NotNull String firstName, String middleName,
			@NotNull String lastName, Double gpa, LocalDate dateOfEnrollment, String isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.isInternational = isInternational;
	}
	
	public Student(Integer studentId, @NotNull String studentNumber, @NotNull String firstName, String middleName,
			@NotNull String lastName, Double gpa, LocalDate dateOfEnrollment, String isInternational) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gpa = gpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.isInternational = isInternational;
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
	
	public String getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(String isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfEnrollment, firstName, gpa, lastName, middleName, studentId, studentNumber, isInternational);
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
		return Objects.equals(dateOfEnrollment, other.dateOfEnrollment)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gpa, other.gpa)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(studentId, other.studentId) && Objects.equals(studentNumber, other.studentNumber)
						&& Objects.equals(isInternational, other.isInternational);
	}

	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, studentNumber=%s, firstName=%s, middleName=%s, lastName=%s, gpa=%s, dateOfEnrollment=%s, isInternational=%s]",
				studentId, studentNumber, firstName, middleName, lastName, gpa, dateOfEnrollment, isInternational);
	}


}
