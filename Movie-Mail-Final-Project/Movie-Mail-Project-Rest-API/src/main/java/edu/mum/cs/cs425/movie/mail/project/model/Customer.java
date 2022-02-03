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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@Column(nullable = false, unique = true)
	private Integer customerNumber;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String fullName;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	private List<DVD> dvdListRented;

	@Embedded
	private Address address;
	
	@Embedded
	private CreditCard creditCard;
	
	@Embedded
	private BankAccount bankAccount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ShoppingCart shoppingCart;
	
	@OneToMany(mappedBy = "customer", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Order> orders;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Watchlist watchlist;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	private List<Subscription> subscriptions;
	
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<Order> getListOrdersCustomer() {
		return orders;
	}

	public void setListOrdersCustomer(List<Order> listOrdersCustomer) {
		this.orders = listOrdersCustomer;
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Watchlist getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(Watchlist watchlist) {
		this.watchlist = watchlist;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public void addDvd(DVD dvd) {
		if(dvdListRented == null) {
			dvdListRented = new ArrayList<>();
		}
		
		if(dvd != null) {
			dvdListRented.add(dvd);
		}
	}
	
	public void addOrder(Order order) {
		if(orders == null) {
			orders = new ArrayList<>();
		}
		
		if(order != null) {
			orders.add(order);
		}
	}
	
	public void addSubscriptions(Subscription subscription) {
		if(subscriptions == null) {
			subscriptions = new ArrayList<>();
		}
		
		if(subscription != null) {
			subscriptions.add(subscription);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, bankAccount, creditCard, customerId, customerNumber, dvdListRented, fullName,
				orders, shoppingCart, subscriptions, watchlist);
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
		return Objects.equals(address, other.address) && Objects.equals(bankAccount, other.bankAccount)
				&& Objects.equals(creditCard, other.creditCard) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerNumber, other.customerNumber)
				&& Objects.equals(dvdListRented, other.dvdListRented) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(orders, other.orders) && Objects.equals(shoppingCart, other.shoppingCart)
				&& Objects.equals(subscriptions, other.subscriptions) && Objects.equals(watchlist, other.watchlist);
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [customerId=%s, customerNumber=%s, fullName=%s, dvdListRented=%s, address=%s, creditCard=%s, bankAccount=%s, shoppingCart=%s, orders=%s, watchlist=%s, subscriptions=%s]",
				customerId, customerNumber, fullName, dvdListRented, address, creditCard, bankAccount, shoppingCart,
				orders, watchlist, subscriptions);
	}

}
