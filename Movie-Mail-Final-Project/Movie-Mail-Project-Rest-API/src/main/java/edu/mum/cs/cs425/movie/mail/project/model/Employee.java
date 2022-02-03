package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String employeeNumber;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String fullName;

	public Employee() {
	}

	public Employee(Long employeeId, @NotNull @NotBlank String employeeNumber, @NotNull @NotBlank String fullName) {
		this.employeeId = employeeId;
		this.employeeNumber = employeeNumber;
		this.fullName = fullName;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeNumber, fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeNumber, other.employeeNumber)
				&& Objects.equals(fullName, other.fullName);
	}

	@Override
	public String toString() {
		return String.format("Employee [employeeId=%s, employeeNumber=%s, fullName=%s]", employeeId, employeeNumber,
				fullName);
	}
	
}
