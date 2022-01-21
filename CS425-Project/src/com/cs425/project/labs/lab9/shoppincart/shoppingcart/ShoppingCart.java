package com.cs425.project.labs.lab9.shoppincart.shoppingcart;
import java.util.ArrayList;
import java.util.Iterator;

import com.cs425.project.labs.lab9.shoppincart.products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartLineList = new ArrayList<CartLine>();
	static final int ONE = 1;
	static final double ZERO = 0.0;

	public void printCartProducts() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cartLine : cartLineList) {
			System.out.println(cartLine.getQuantity() + " "
					+ cartLine.getProduct().getProductnumber() + " "
					+ cartLine.getProduct().getDescription() + " "
					+ cartLine.getProduct().getPrice());
		}
		System.out.println("Total price ="+getTotalPrice());
	}

	public void removeFromCart(Product product) {
		Iterator<CartLine> iterator = cartLineList.iterator();
		while (iterator.hasNext()){
			CartLine cartLine = iterator.next();
			if (isProductNumberEqual(cartLine, product)){
				if(cartLine.getQuantity()>ONE) {
					cartLine.setQuantity(cartLine.getQuantity()-ONE);
				} else {
					iterator.remove();
				}
			}
		}
	}
		
	private boolean isProductNumberEqual(CartLine cartLine, Product product) {
		return cartLine.getProduct().getProductnumber().equals(product.getProductnumber());
	}


	public void addToCart(Product product) {
		for (CartLine cartLine : cartLineList) {
			if (isProductNumberEqual(cartLine, product)) {
				cartLine.setQuantity(cartLine.getQuantity()+ONE);
				return;
			}
		}
		CartLine cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setQuantity(ONE);
		cartLineList.add(cartLine);	
	}


	private double getTotalPrice(){
		double totalPrice = ZERO;
		for (CartLine cartLine : cartLineList) {
			totalPrice=totalPrice+(cartLine.getProduct().getPrice() * cartLine.getQuantity());
		}
		return totalPrice;
	}
}
