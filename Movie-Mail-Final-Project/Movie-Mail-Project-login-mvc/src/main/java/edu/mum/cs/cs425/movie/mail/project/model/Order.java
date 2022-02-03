package edu.mum.cs.cs425.movie.mail.project.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

//@Entity
public class Order {

	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String orderNumber;
	@DateTimeFormat
	private LocalDate dateOrder;
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String purchaseDescription;
//	@ManyToOne(mappedBy = "listOrdersCustomer", cascade = CascadeType.ALL)
//	private Customer customer;
	
	
}
