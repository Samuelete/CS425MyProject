package com.cs425.project.labs.lab9.shoppincart.application;

import com.cs425.project.labs.lab9.shoppincart.products.Product;
import com.cs425.project.labs.lab9.shoppincart.shoppingcart.ShoppingCart;

public class Application {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Product tvProduct = new Product("A123", 100.0, "TV");
		cart.action(tvProduct,"add");
		Product mp3Player = new Product("A665", 75.0, "MP3 Player");
		cart.action(mp3Player,"add");
		Product secondMp3Player = new Product("A665", 75.0, "MP3 Player");
		cart.action(secondMp3Player,"add");
		
		cart.action(null,"print");
		
		cart.action(secondMp3Player,"remove");
		cart.action(mp3Player,"remove");
		
		cart.action(null,"print");

	}

}
