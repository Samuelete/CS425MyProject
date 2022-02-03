package edu.mum.cs.cs425.movie.mail.project.model;

import java.time.LocalDate;

public abstract class Subscription {

	protected Integer basePrice;
	protected LocalDate endDate;
	protected Integer dvdAtHome;
	protected Integer dvdMonthly;
	
	protected abstract void addDvdHome();
}
