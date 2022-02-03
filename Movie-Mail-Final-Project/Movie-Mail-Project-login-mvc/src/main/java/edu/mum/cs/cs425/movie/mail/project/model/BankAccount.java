package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.Objects;

public class BankAccount {

	private String bankName;
	private String routingNumber;
	private String accounNumber;
	private Double balance;
	
	public BankAccount() {
	}

	public BankAccount(String bankName, String routingNumber, String accounNumber, Double balance) {
		super();
		this.bankName = bankName;
		this.routingNumber = routingNumber;
		this.accounNumber = accounNumber;
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccounNumber() {
		return accounNumber;
	}

	public void setAccounNumber(String accounNumber) {
		this.accounNumber = accounNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public boolean checkBalance(Double payment) {
		return this.balance > payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounNumber, balance, bankName, routingNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accounNumber, other.accounNumber) && Objects.equals(balance, other.balance)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(routingNumber, other.routingNumber);
	}

	@Override
	public String toString() {
		return String.format("BankAccount [bankName=%s, routingNumber=%s, accounNumber=%s, balance=%s]", bankName,
				routingNumber, accounNumber, balance);
	}
	
	
	
}
