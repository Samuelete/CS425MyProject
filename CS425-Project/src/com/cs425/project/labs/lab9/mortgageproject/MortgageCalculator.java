package com.cs425.project.labs.lab9.mortgageproject;
import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {
	
	static final int ZERO_DOLLARS = 0;
	static final int EIGHTEEN_YEARS = 18;
	static final int TWO_THOUSAND_DOLLARS = 2000;
	static final int THREE_THOUSAND_DOLLARS = 3000;
	static final int FIVE_THOUSAND_DOLLARS = 5000;
	static final int ONE_HUNDRED_TWENTY_THOUSAND_DOLLARS = 120000;
	static final int ONE_HUNDRED_FOURTY_THOUSAND_DOLLARS = 140000;
	static final int ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS = 160000;
	static final int ONE_HUNDRED_EIGHTY_THOUSAND_DOLLARS = 180000;
	static final int TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS = 220000;
	static final int TWO_HUNDRED_FIFTY_THOUSAND_DOLLARS = 250000;
	static final int TWO_HUNDRED_EIGHTY_THOUSAND_DOLLARS = 280000;
	
	public double computeMaxMortgage(Customer customer) {
		
		double totalMonthlyMortage = 0;
		
		if(!isAdult(customer, EIGHTEEN_YEARS)) {
			return 0.0;
		}
		
		if(isMarried(customer.getMarriedStatus())) {
			totalMonthlyMortage = computeMontlyMarriageIncome(customer);
		}
		return computeMortageIncome(customer, totalMonthlyMortage);
	}

	private double computeMontlyMarriageIncome(Customer customer) {
		final double RATE = 0.94;
		return customer.getMonthlyIncome() + customer.getMonthlyIncomePartner() * RATE;
	}

	private double computeMortageIncome(Customer customer, double monthlyIncome) {
		if(isCostumerLowIncome(monthlyIncome)) {
			return computeLowIncome(customer.getProfession());
		}
		if(isCostumerMiddleIncome(monthlyIncome)) {
			return computeMiddleIncome(customer.getProfession());
		}
		if(isCostumerHighIncome(monthlyIncome)) {
			return computeHighIncome(customer.getProfession());
		}
		return 0;
	}

	private double computeLowIncome(String profession) {
		
		switch(profession) {
			case "Developer" : case "Architect" : case "Scrum master" : return ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS;
			case "Tester" : case "System Administrator" : case "Technical writer" : return ONE_HUNDRED_TWENTY_THOUSAND_DOLLARS;
			case "Deparment Head" : case "Professor" : return TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS;
		}
		return 0;
	}
	
	private double computeMiddleIncome(String profession) {
		
		switch(profession) {
			case "Developer" : case "Architect" : case "Scrum master" : return ONE_HUNDRED_EIGHTY_THOUSAND_DOLLARS;
			case "Tester" : case "System Administrator" : case "Technical writer" : return ONE_HUNDRED_FOURTY_THOUSAND_DOLLARS;
			case "Deparment Head" : case "Professor" : return TWO_HUNDRED_FIFTY_THOUSAND_DOLLARS;
		}
		return 0;
	}
	
	private double computeHighIncome(String profession) {
		
		switch(profession) {
			case "Developer" : case "Architect" : case "Scrum master" : return TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS;
			case "Tester" : case "System Administrator" : case "Technical writer" : return ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS;
			case "Deparment Head" : case "Professor" : return TWO_HUNDRED_EIGHTY_THOUSAND_DOLLARS;
		}
		return 0;
	}
	
	private boolean isCostumerLowIncome(double monthlyIncome) {
		return TWO_THOUSAND_DOLLARS <= monthlyIncome && monthlyIncome < THREE_THOUSAND_DOLLARS;
	}
	private boolean isCostumerMiddleIncome(double monthlyIncome) {
		return THREE_THOUSAND_DOLLARS <= monthlyIncome && monthlyIncome < FIVE_THOUSAND_DOLLARS;
	}
	private boolean isCostumerHighIncome(double monthlyIncome) {
		return FIVE_THOUSAND_DOLLARS <= monthlyIncome;
	}


	private boolean isMarried(MarriedStatus marriedStatus) {
		return marriedStatus == MarriedStatus.MARRIED ? true : false;
	}


	private boolean isAdult(Customer customer, int eighteenYears) {
		return calculateAge(customer.getBirthday()) > eighteenYears;
	}

	private int calculateAge(LocalDate birthday) {
		
		LocalDate todayDate = LocalDate.now();                          
		
		return Period.between(birthday, todayDate).getYears();
	}

}
