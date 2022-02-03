package edu.mum.cs.cs425.movie.mail.project.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shoppingCardId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<DVD> dvdsOnCart;

	public ShoppingCart() {
		super();
	}
	
	public ShoppingCart(Long shoppingCardId, List<DVD> dvdsOnCart) {
		this.shoppingCardId = shoppingCardId;
		this.dvdsOnCart = dvdsOnCart;
	}
	
	public Long getShoppingCardId() {
		return shoppingCardId;
	}

	public void setShoppingCardId(Long shoppingCardId) {
		this.shoppingCardId = shoppingCardId;
	}

	public List<DVD> getDvdsOnCart() {
		return dvdsOnCart;
	}

	public void setDvdsOnCart(List<DVD> dvdsOnCart) {
		this.dvdsOnCart = dvdsOnCart;
	}
 
	public void addDvdToCart(DVD dvd) {
		if(dvdsOnCart == null) {
			dvdsOnCart = new ArrayList<>();
		}
		if(dvd != null) {
			dvdsOnCart.add(dvd);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(dvdsOnCart, shoppingCardId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		return Objects.equals(dvdsOnCart, other.dvdsOnCart) && Objects.equals(shoppingCardId, other.shoppingCardId);
	}

	@Override
	public String toString() {
		return String.format("ShoppingCart [shoppingCardId=%s, dvdsOnCart=%s]", shoppingCardId, dvdsOnCart);
	}
	
	

	
	
	
}
