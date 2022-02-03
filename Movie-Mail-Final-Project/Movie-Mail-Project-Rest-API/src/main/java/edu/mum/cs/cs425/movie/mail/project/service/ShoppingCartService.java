package edu.mum.cs.cs425.movie.mail.project.service;

import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.model.ShoppingCart;

public interface ShoppingCartService {
	public abstract ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);
	public abstract ShoppingCart getShoppingCartById(Long shoppingCartId);
	public abstract void deleteShoppingCartById(Long shoppingCartId);
	public abstract void addDvdToCart(ShoppingCart shoppingCart, DVD dvd);
	void removeDvdToCart(ShoppingCart shoppingCart, Long dvdId);
	public abstract void cleanShoppingCart(ShoppingCart shoppingCart);
}
