package edu.mum.cs.cs425.movie.mail.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.movie.mail.project.model.CreditCard;
import edu.mum.cs.cs425.movie.mail.project.model.Epay;
import edu.mum.cs.cs425.movie.mail.project.repository.EpayRepository;
import edu.mum.cs.cs425.movie.mail.project.service.EpayService;

@Service
public class EpayServiceImpl implements EpayService {

	@Autowired
	private EpayRepository epayRepository;
	
	@Override
	public CreditCard findAllByCardNumber(String cardNumber) {
		
		List<Epay> epays = epayRepository.findAll();
		
		for (Epay epay : epays) {
			if(epay.getCreditCard().getCardNumber().equals(cardNumber)); {
				return epay.getCreditCard();
			}
		}
		return null;
	}

}
