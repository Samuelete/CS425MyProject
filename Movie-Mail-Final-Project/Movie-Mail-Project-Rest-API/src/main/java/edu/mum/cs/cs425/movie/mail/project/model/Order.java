package edu.mum.cs.cs425.movie.mail.project.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(nullable = false)
	private Long orderNumber;
	
	@DateTimeFormat
	private LocalDate dateOrder;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String purchaseDescription;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Order() {
	}

	
	public Order(Long orderId, Long orderNumber, LocalDate dateOrder, @NotNull @NotBlank String purchaseDescription) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.dateOrder = dateOrder;
		this.purchaseDescription = purchaseDescription;
	}

	
	
	public Order(@NotNull @NotBlank Long orderNumber, LocalDate dateOrder) {
		super();
		this.orderNumber = orderNumber;
		this.dateOrder = dateOrder;
	}


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(LocalDate dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getPurchaseDescription() {
		return purchaseDescription;
	}

	public void setPurchaseDescription(String purchaseDescription) {
		this.purchaseDescription = purchaseDescription;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, dateOrder, orderId, orderNumber, purchaseDescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(dateOrder, other.dateOrder)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(orderNumber, other.orderNumber)
				&& Objects.equals(purchaseDescription, other.purchaseDescription);
	}

	@Override
	public String toString() {
		return String.format("Order [orderId=%s, orderNumber=%s, dateOrder=%s, purchaseDescription=%s, customer=%s]",
				orderId, orderNumber, dateOrder, purchaseDescription, customer);
	}
	
}
