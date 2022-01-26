package edu.mum.cs.cs425.studentmgmt.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classrooms")
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="classroom_id")
	private Integer classroomId;
	@Column(name="building_name", nullable = false)
	private String buildingName;
	@Column(name="room_number", nullable = false)
	private String roomNumber;
	
	@OneToMany(mappedBy = "classroom", cascade=CascadeType.ALL)
	private List<Student> students;
	
	Classroom() {}

	public Classroom(String buildingName, String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Classroom(Integer classroomId, String buildingName, String roomNumber, List<Student> students) {
		super();
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.students = students;
	}

	public Integer getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buildingName, classroomId, roomNumber, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classroom other = (Classroom) obj;
		return Objects.equals(buildingName, other.buildingName) && Objects.equals(classroomId, other.classroomId)
				&& Objects.equals(roomNumber, other.roomNumber) && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return String.format("Classroom [classroomId=%s, buildingName=%s, roomNumber=%s, students=%s]", classroomId,
				buildingName, roomNumber, students);
	}
	
	
	
}
