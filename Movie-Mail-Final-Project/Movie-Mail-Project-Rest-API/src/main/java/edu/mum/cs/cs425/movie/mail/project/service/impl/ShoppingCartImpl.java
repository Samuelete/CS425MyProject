package edu.mum.cs.cs425.movie.mail.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.model.ShoppingCart;
import edu.mum.cs.cs425.movie.mail.project.repository.ShoppingCartRepository;
import edu.mum.cs.cs425.movie.mail.project.service.ShoppingCartService;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository  shoppingCartRepository;
	
	@Override
	public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public ShoppingCart getShoppingCartById(Long shoppingCartId) {
		System.out.println("SHOPPINGCARDID: " + shoppingCartId);
		return shoppingCartId == null ? new ShoppingCart() : shoppingCartRepository.getById(shoppingCartId);
	}

	@Override
	public void deleteShoppingCartById(Long shoppingCartId) {
		shoppingCartRepository.deleteById(shoppingCartId);
		
	}

	@Override
	public void removeDvdToCart(ShoppingCart shoppingCart, Long dvdId) {
		List<DVD> dvds = shoppingCart.getDvdsOnCart();
		for (DVD dvd : dvds) {
			if(dvd.getDvdId() == dvdId) {
				shoppingCart.getDvdsOnCart().remove(dvd);
				break;
			}
		}
	}

	@Override
	public void addDvdToCart(ShoppingCart shoppingCart, DVD dvd) {
		shoppingCart.addDvdToCart(dvd);
	}

	@Override
	public void cleanShoppingCart(ShoppingCart shoppingCart) {
		shoppingCart.getDvdsOnCart().clear();
	}

	
}
