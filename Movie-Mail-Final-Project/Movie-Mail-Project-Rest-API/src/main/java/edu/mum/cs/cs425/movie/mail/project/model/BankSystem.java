package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankSystemId;
	
	@Embedded
	BankAccount bankAccount;

	public BankSystem() {
	}

	public BankSystem(Long bankSystemId, BankAccount bankAccount) {
		this.bankSystemId = bankSystemId;
		this.bankAccount = bankAccount;
	}

	public Long getBankSystemId() {
		return bankSystemId;
	}

	public void setBankSystemId(Long bankSystemId) {
		this.bankSystemId = bankSystemId;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankAccount, bankSystemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankSystem other = (BankSystem) obj;
		return Objects.equals(bankAccount, other.bankAccount) && Objects.equals(bankSystemId, other.bankSystemId);
	}

	@Override
	public String toString() {
		return String.format("BankSystem [bankSystemId=%s, bankAccount=%s]", bankSystemId, bankAccount);
	}
	
}
