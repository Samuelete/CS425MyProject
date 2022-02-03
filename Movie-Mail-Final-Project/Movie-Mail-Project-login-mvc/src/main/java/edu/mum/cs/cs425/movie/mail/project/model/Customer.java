package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private Integer customerNumber;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String fullName;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	private List<DVD> dvdListRented;

//	@Embedded
//	private List<CreditCard> listCreditCards;
//	
//	@Embedded
//	private BankAccount bankAccount;
//	
//	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.DETACH,CascadeType.REFRESH})
//	private List<Order> listOrdersCustomer;
//	
//	@Embedded
//	private List<String> watchlist;
	
	public Customer() {
	}

	public Customer(Long customerId, @NotNull @NotBlank Integer customerNumber, @NotNull @NotBlank String fullName) {
		super();
		this.customerId = customerId;
		this.customerNumber = customerNumber;
		this.fullName = fullName;
	}
	
	public Customer(@NotNull @NotBlank Integer customerNumber, @NotNull @NotBlank String fullName) {
		this.customerNumber = customerNumber;
		this.fullName = fullName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<DVD> getDvdListRented() {
		return dvdListRented;
	}

	public void setDvdListRented(List<DVD> dvdListRented) {
		this.dvdListRented = dvdListRented;
	}
	
	public void addDvd(DVD dvd) {
		if(dvd == null) {
			dvdListRented = new ArrayList<>();
		}
		dvdListRented.add(dvd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, customerNumber, dvdListRented, fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(customerNumber, other.customerNumber)
				&& Objects.equals(dvdListRented, other.dvdListRented) && Objects.equals(fullName, other.fullName);
	}

	@Override
	public String toString() {
		return String.format("Customer [customerId=%s, customerNumber=%s, fullName=%s, dvdListRented=%s]", customerId,
				customerNumber, fullName, dvdListRented);
	}
	
	
//	private List<CreditCard> listCreditCards;
//	private BankAccount bankAccount;
//	private Login loginAccount;
//	private List<Order> listOrdersCustomer;
//	private ShoppingCart shoppingCart;
//	private List<String> watchlist;
//	private Subscription subscription;
	
	
	
}
