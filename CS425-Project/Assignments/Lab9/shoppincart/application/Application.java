package com.cs425.project.labs.lab9.shoppincart.application;

import com.cs425.project.labs.lab9.shoppincart.products.Product;
import com.cs425.project.labs.lab9.shoppincart.shoppingcart.ShoppingCart;

public class Application {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Product tvProduct = new Product("A123", 100.0, "TV");
		
		cart.addToCart(tvProduct);

		Product mp3Player = new Product("A665", 75.0, "MP3 Player");
		
		cart.addToCart(mp3Player);
		
		Product secondMp3Player = new Product("A665", 75.0, "MP3 Player");
		
		cart.addToCart(secondMp3Player);

		cart.printCartProducts();
		
		cart.removeFromCart(secondMp3Player);
		cart.removeFromCart(mp3Player);
		
		cart.printCartProducts();

	}

}
