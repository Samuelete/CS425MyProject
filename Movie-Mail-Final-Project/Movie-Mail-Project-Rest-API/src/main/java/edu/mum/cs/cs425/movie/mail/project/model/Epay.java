package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Epay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long epayId;
	
	@Embedded
	private CreditCard creditCard;

	public Epay() {
	}

	public Epay(Long epayId, CreditCard creditCard) {
		this.epayId = epayId;
		this.creditCard = creditCard;
	}

	public Long getEpayId() {
		return epayId;
	}

	public void setEpayId(Long epayId) {
		this.epayId = epayId;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditCard, epayId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epay other = (Epay) obj;
		return Objects.equals(creditCard, other.creditCard) && Objects.equals(epayId, other.epayId);
	}

	@Override
	public String toString() {
		return String.format("Epay [epayId=%s, creditCard=%s]", epayId, creditCard);
	}
	
}
