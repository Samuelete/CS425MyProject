package edu.mum.cs.cs425.movie.mail.project.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public abstract class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(nullable = false)
	protected Integer basePrice;
	
	@DateTimeFormat
	protected LocalDate endDate;
	
	@Column(nullable = false)
	protected Integer dvdAtHome;
	
	@Column(nullable = false)
	protected Integer dvdMonthly;
	
	public Subscription() {
	}

	public Subscription(Integer basePrice, LocalDate endDate, Integer dvdAtHome, Integer dvdMonthly) {
		this.basePrice = basePrice;
		this.endDate = endDate;
		this.dvdAtHome = dvdAtHome;
		this.dvdMonthly = dvdMonthly;
	}

	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getDvdAtHome() {
		return dvdAtHome;
	}

	public void setDvdAtHome(Integer dvdAtHome) {
		this.dvdAtHome = dvdAtHome;
	}

	public Integer getDvdMonthly() {
		return dvdMonthly;
	}

	public void setDvdMonthly(Integer dvdMonthly) {
		this.dvdMonthly = dvdMonthly;
	}

	protected abstract void addDvdHome();

	@Override
	public int hashCode() {
		return Objects.hash(basePrice, dvdAtHome, dvdMonthly, endDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		return Objects.equals(basePrice, other.basePrice) && Objects.equals(dvdAtHome, other.dvdAtHome)
				&& Objects.equals(dvdMonthly, other.dvdMonthly) && Objects.equals(endDate, other.endDate);
	}

	@Override
	public String toString() {
		return String.format("Subscription [basePrice=%s, endDate=%s, dvdAtHome=%s, dvdMonthly=%s]", basePrice, endDate,
				dvdAtHome, dvdMonthly);
	}
	
	
}
