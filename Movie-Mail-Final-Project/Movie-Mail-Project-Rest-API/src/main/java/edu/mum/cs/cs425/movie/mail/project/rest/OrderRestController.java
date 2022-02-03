package edu.mum.cs.cs425.movie.mail.project.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.mum.cs.cs425.movie.mail.project.model.CreditCard;
import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.model.Order;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;
import edu.mum.cs.cs425.movie.mail.project.service.EpayService;
import edu.mum.cs.cs425.movie.mail.project.service.OrderService;
import edu.mum.cs.cs425.movie.mail.project.service.ShoppingCartService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:8080"}, allowedHeaders = "*")
@RequestMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private EpayService epayService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	public OrderRestController(CustomerService customerService, OrderService orderService, EpayService epayService,
			ShoppingCartService shoppingCartService) {
		this.customerService = customerService;
		this.orderService = orderService;
		this.epayService = epayService;
		this.shoppingCartService = shoppingCartService;
	}

	@PostMapping(value = "/placeorder/{customerId}")
	public String placerOrder(@PathVariable Long customerId) {
		return verifyCreditCard(customerId) ? createPurchase(customerId) : "Credit Card Rejected";
	}

	private boolean verifyCreditCard(Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		CreditCard creditCard = epayService.findAllByCardNumber(customer.getCreditCard().getCardNumber());
		if(creditCard == null) {
			return false;
		}
	
		return validateCreditCard(customer, creditCard);
	}

	private boolean validateCreditCard(Customer customer, CreditCard creditCard) {

		if(!customer.getCreditCard().getCardNumber().equals(creditCard.getCardNumber())) {
			return false;
		}
		
		if(!customer.getCreditCard().getCompany().equals(creditCard.getCompany())) {
			return false;
		}
			
		if(customer.getCreditCard().getExpireDate().compareTo(creditCard.getExpireDate()) != 0){
			return false;
		}
		
		return true;
	}




	private String createPurchase(Long customerId) {
		
		Customer customer = customerService.getCustomerById(customerId);		
		Order order = new Order(generateOrderNumber(),
				LocalDate.now());
		
		String purchaseDescription = createPurchaseDescription(customer, order);
		String purchaseDone = "Purchase Completed";
		order.setPurchaseDescription(purchaseDone);
		
		order = orderService.saveOrder(order);
		
		addDvdsToCustomer(customer);
		
		customerService.addNewOrder(customer, order);
		order.setCustomer(customer);
		customerService.saveCustomer(customer);
		orderService.saveOrder(order);
		
		clearShoppingCart(customer);
		
		return purchaseDescription;
	}



	private void clearShoppingCart(Customer customer) {
		customer.getShoppingCart().getDvdsOnCart().clear();
		shoppingCartService.saveShoppingCart(customer.getShoppingCart());
	}



	private void addDvdsToCustomer(Customer customer) {

		List<DVD> dvdsShoppingCart = customer.getShoppingCart().getDvdsOnCart();
		
		for(DVD dvd : dvdsShoppingCart) {
			customer.addDvd(dvd);
		}
		
	}



	private String createPurchaseDescription(Customer customer, Order order) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Your order have been succesfully process!" + System.lineSeparator())
		.append("Order number: " + order.getOrderNumber() + System.lineSeparator() )
		.append("with the list of DVDs:" + System.lineSeparator());
		
		List<DVD> dvdsPurchase = customer.getShoppingCart().getDvdsOnCart();
		
		for(DVD dvd : dvdsPurchase) {
			sb.append(dvd.getTitle() + ", Directed By: " + dvd.getFilmmaker() + System.lineSeparator());
		}
		
		sb.append("In a few days your order will send to your home" + System.lineSeparator())
		.append("We will send you an confirmation email." + System.lineSeparator())
		.append("Thank you very much for you purchase!");
		
		return sb.toString();
	}
	
	private Long generateOrderNumber() {
		Random random = new Random();
		final Long ORDER_NUMBER_LIMIT = (long) 10000000;
		return random.nextLong(ORDER_NUMBER_LIMIT);
	}
	
	@PostMapping(value = "/findCard/{cardNumber}")
	public CreditCard findCard(@PathVariable String cardNumber) {
		return epayService.findAllByCardNumber(cardNumber);
	}
	
}
