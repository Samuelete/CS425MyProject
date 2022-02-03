package edu.mum.cs.cs425.movie.mail.project.service;

import edu.mum.cs.cs425.movie.mail.project.model.CreditCard;

public interface EpayService {
	public abstract CreditCard findAllByCardNumber(String cardNumber);
}
