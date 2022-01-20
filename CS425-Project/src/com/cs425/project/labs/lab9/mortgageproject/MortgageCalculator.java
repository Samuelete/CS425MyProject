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
	
	public double computeMaxMortgage(int yearOfBirt, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
		double mortgageResult=0;

		int age = calculateAge(yearOfBirt, month, day);
		
		System.out.println(age);

		if (isMarried(married)) {
			if (age >EIGHTEEN_YEARS && TWO_THOUSAND_DOLLARS<=monthlyIncome && monthlyIncome<THREE_THOUSAND_DOLLARS) {
				mortgageResult = computeMaxMortage(ONE_HUNDRED_TWENTY_THOUSAND_DOLLARS,
						ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS,
						profession);
			}
			if (age >EIGHTEEN_YEARS && THREE_THOUSAND_DOLLARS<=monthlyIncome && monthlyIncome<FIVE_THOUSAND_DOLLARS) {
				mortgageResult = computeMaxMortage(ONE_HUNDRED_FOURTY_THOUSAND_DOLLARS,
						ONE_HUNDRED_EIGHTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_FIFTY_THOUSAND_DOLLARS,
						profession);
			}
			if (age >EIGHTEEN_YEARS && FIVE_THOUSAND_DOLLARS<=monthlyIncome) {
				mortgageResult = computeMaxMortage(ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_EIGHTY_THOUSAND_DOLLARS,
						profession);
			}
			if (age < EIGHTEEN_YEARS) {
				mortgageResult = ZERO_DOLLARS;
			}
		}
		else {
			double totalIncome = monthlyIncome + monthlyIncomePartner * 0.94; 
			if (age >EIGHTEEN_YEARS && TWO_THOUSAND_DOLLARS<=totalIncome && totalIncome<THREE_THOUSAND_DOLLARS) {
				mortgageResult = computeMaxMortage(ONE_HUNDRED_TWENTY_THOUSAND_DOLLARS,
						ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS,
						profession);
			}
			if (age >EIGHTEEN_YEARS && THREE_THOUSAND_DOLLARS<=totalIncome && totalIncome<FIVE_THOUSAND_DOLLARS) {
				mortgageResult = computeMaxMortage(ONE_HUNDRED_FOURTY_THOUSAND_DOLLARS,
						ONE_HUNDRED_EIGHTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_FIFTY_THOUSAND_DOLLARS,
						profession);
			}
			if (age >EIGHTEEN_YEARS && FIVE_THOUSAND_DOLLARS<=totalIncome) {
				mortgageResult = computeMaxMortage(ONE_HUNDRED_SIXTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_TWENTY_THOUSAND_DOLLARS,
						TWO_HUNDRED_EIGHTY_THOUSAND_DOLLARS,
						profession);
			}
			if (age < EIGHTEEN_YEARS) {
				mortgageResult = ZERO_DOLLARS;
			}

		}
		
		return mortgageResult;
	}
	
	/* The int parameters vary according the condition of the if statement where 
	 * this method is called */
	private double computeMaxMortage(int amountOne, int amountTwo, int amountThree, String profession) {
		
		double mortgageResult = ZERO_DOLLARS;
		
		switch(profession) {
			case "Developer": mortgageResult = amountTwo; break;
			case "Architect": mortgageResult = amountTwo; break;
			case "Scrum master": mortgageResult = amountTwo; break;
			case "Tester": mortgageResult = amountOne; break;
			case "System Administrator": mortgageResult = amountOne; break;
			case "Technical writer": mortgageResult = amountOne; break;
			case "Department head": mortgageResult = amountThree; break;
			case "Professor": mortgageResult = amountThree; break;
		}
		return mortgageResult;
	}

	private boolean isMarried(boolean married) {
		return married;
	}

	private int calculateAge(int yearOfBirt, int month, int day) {
		
		LocalDate todayDate = LocalDate.now();                          
		LocalDate birthdayCustomer = LocalDate.of(yearOfBirt, month, day);
		return Period.between(birthdayCustomer, todayDate).getYears();
	}

}
