package com.cs425.project.labs.lab9.mortgageproject;

import java.time.LocalDate;

public class Customer {

	private LocalDate birthday;
	private MarriedStatus marriedStatus;
	private double monthlyIncome;
	private double monthlyIncomePartner;
	private String profession;
	
	public Customer(LocalDate birthday, MarriedStatus marriedStatus, double monthlyIncome, double monthlyIncomePartner,
			String profession) {
		this.birthday = birthday;
		this.marriedStatus = marriedStatus;
		this.monthlyIncome = monthlyIncome;
		this.monthlyIncomePartner = monthlyIncomePartner;
		this.profession = profession;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public MarriedStatus getMarriedStatus() {
		return marriedStatus;
	}

	public void setMarriedStatus(MarriedStatus marriedStatus) {
		this.marriedStatus = marriedStatus;
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public double getMonthlyIncomePartner() {
		return monthlyIncomePartner;
	}

	public void setMonthlyIncomePartner(double monthlyIncomePartner) {
		this.monthlyIncomePartner = monthlyIncomePartner;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Customer [birthday=" + birthday + ", marriedStatus=" + marriedStatus + ", monthlyIncome="
				+ monthlyIncome + ", monthlyIncomePartner=" + monthlyIncomePartner + ", profession=" + profession + "]";
	}
	
	
	
	
}
