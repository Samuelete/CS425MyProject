package com.cs425.project.labs.lab9.shoppincart.shoppingcart;

import com.cs425.project.labs.lab9.shoppincart.products.Product;

public class CartLine {
	int quantity;
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
