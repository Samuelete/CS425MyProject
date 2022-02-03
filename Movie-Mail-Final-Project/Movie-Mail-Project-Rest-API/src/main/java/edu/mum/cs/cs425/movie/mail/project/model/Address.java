package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String street;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String city;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String state;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String country;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String zipCode;

	public Address() {
	}

	public Address(@NotNull @NotBlank String street, @NotNull @NotBlank String city, @NotNull @NotBlank String state,
			@NotNull @NotBlank String country, @NotNull @NotBlank String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, state, street, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return String.format("Address [street=%s, city=%s, state=%s, country=%s, zipCode=%s]", street, city, state,
				country, zipCode);
	}
	
}
