package edu.mum.cs.cs425.movie.mail.project.model;

import java.time.LocalDate;
import java.util.Objects;

public class CreditCard {

	private String cardNumber;
	private LocalDate expireDate;
	private String Company;
	
	public CreditCard() {
	}

	public CreditCard(String cardNumber, LocalDate expireDate, String company) {
		this.cardNumber = cardNumber;
		this.expireDate = expireDate;
		Company = company;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Company, cardNumber, expireDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return Objects.equals(Company, other.Company) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(expireDate, other.expireDate);
	}

	@Override
	public String toString() {
		return String.format("CreditCard [cardNumber=%s, expireDate=%s, Company=%s]", cardNumber, expireDate, Company);
	}
	
	
	
	
}
