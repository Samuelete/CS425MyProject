package edu.mum.cs.cs425.studentmgmt.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="transcripts")
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transcript_id")
	private Integer transcriptId;
	
	@Column(name="degree_title")
	private String degreeTitle;
	
	@OneToOne(mappedBy="transcript", cascade = CascadeType.ALL)
	private Student student;

	public Transcript() {}
	
	

	public Transcript(@NotNull String degreeTitle, Student student) {
		super();
		this.degreeTitle = degreeTitle;
		this.student = student;
	}

	public Transcript(Integer transcriptId, @NotNull String degreeTitle, Student student) {
		super();
		this.transcriptId = transcriptId;
		this.degreeTitle = degreeTitle;
		this.student = student;
	}

	public Integer getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Integer transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		return Objects.hash(degreeTitle, student, transcriptId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transcript other = (Transcript) obj;
		return Objects.equals(degreeTitle, other.degreeTitle) && Objects.equals(student, other.student)
				&& Objects.equals(transcriptId, other.transcriptId);
	}

	@Override
	public String toString() {
		return String.format("Transcript [transcriptId=%s, degreeTitle=%s, student=%s]", transcriptId, degreeTitle,
				student);
	}
	
	
	
}
