package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dvds")
public class DVD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dvdId;
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String barCode;
	
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String title;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String filmmaker;
	
	@Column(nullable = false)
	private Integer mostPopular;
	
	@Column(nullable = false)
	private Double rate;
	
	@Column(nullable = false)
	private Integer yearOfRelease;

	public DVD() {
	}

	public DVD(Long dvdId, @NotNull @NotBlank String barCode, @NotNull @NotBlank String title,
			@NotNull @NotBlank String filmmaker, Integer mostPopular, Double rate, Integer yearOfRelease) {
		super();
		this.dvdId = dvdId;
		this.barCode = barCode;
		this.title = title;
		this.filmmaker = filmmaker;
		this.mostPopular = mostPopular;
		this.rate = rate;
		this.yearOfRelease = yearOfRelease;
	}

	public Long getDvdId() {
		return dvdId;
	}

	public void setDvdId(Long dvdId) {
		this.dvdId = dvdId;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilmmaker() {
		return filmmaker;
	}

	public void setFilmmaker(String filmmaker) {
		this.filmmaker = filmmaker;
	}

	public Integer getMostPopular() {
		return mostPopular;
	}

	public void setMostPopular(Integer mostPopular) {
		this.mostPopular = mostPopular;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(Integer yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barCode, dvdId, filmmaker, mostPopular, rate, title, yearOfRelease);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DVD other = (DVD) obj;
		return Objects.equals(barCode, other.barCode) && Objects.equals(dvdId, other.dvdId)
				&& Objects.equals(filmmaker, other.filmmaker) && Objects.equals(mostPopular, other.mostPopular)
				&& Objects.equals(rate, other.rate) && Objects.equals(title, other.title)
				&& Objects.equals(yearOfRelease, other.yearOfRelease);
	}

	@Override
	public String toString() {
		return String.format(
				"DVD [dvdId=%s, barCode=%s, title=%s, filmmaker=%s, mostPopular=%s, rate=%s, yearOfRelease=%s]", dvdId,
				barCode, title, filmmaker, mostPopular, rate, yearOfRelease);
	}
	
}
