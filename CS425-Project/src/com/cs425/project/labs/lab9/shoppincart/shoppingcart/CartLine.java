package com.cs425.project.labs.lab9.shoppincart.shoppingcart;

import com.cs425.project.labs.lab9.shoppincart.products.Product;

public class CartLine {
	int q;
	Product p;

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

}
