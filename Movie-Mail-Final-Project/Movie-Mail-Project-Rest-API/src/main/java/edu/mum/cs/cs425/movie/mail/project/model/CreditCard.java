package edu.mum.cs.cs425.movie.mail.project.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class CreditCard {

	private String cardNumber;
	private LocalDate expireDate;
	private String company;
	
	public CreditCard() {
	}

	public CreditCard(String cardNumber, LocalDate expireDate, String company) {
		this.cardNumber = cardNumber;
		this.expireDate = expireDate;
		this.company = company;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardNumber, company, expireDate);
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
		return Objects.equals(cardNumber, other.cardNumber) && Objects.equals(company, other.company)
				&& Objects.equals(expireDate, other.expireDate);
	}

	@Override
	public String toString() {
		return String.format("CreditCard [cardNumber=%s, expireDate=%s, company=%s]", cardNumber, expireDate, company);
	}

	
	
	
	
	
	
}
