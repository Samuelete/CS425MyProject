package edu.mum.cs.cs425.movie.mail.project.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.movie.mail.project.model.Address;
import edu.mum.cs.cs425.movie.mail.project.model.BankAccount;
import edu.mum.cs.cs425.movie.mail.project.model.CreditCard;
import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.model.Watchlist;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:8080"}, allowedHeaders = "*")
@RequestMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {

	@Autowired
	private CustomerService customerServive;
	
	@PostMapping(value = "/placeorder/{customerId}")
	public List<DVD> customerDvds(@Valid @RequestBody DVD dvd,
			@PathVariable Integer customerId) {
		
		Customer customer = customerServive.getCustomerById((long) customerId);
		customer.addDvd(dvd);
		customerServive.saveCustomer(customer);		
		return customer.getDvdListRented();
	}
	
	@PostMapping( value = "/save")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return customerServive.saveCustomer(customer);
	}
	
	@GetMapping(value = "/list")
	public List<Customer> displayCustomers() {
		return customerServive.getAllCustomers();
	}
	
	@PostMapping(value = "/addCreditCard/{customerId}")
	public CreditCard addCreditCard(@Valid @RequestBody CreditCard creditCard,
			@PathVariable Integer customerId) {
		Customer customer = customerServive.getCustomerById((long) customerId);
		customer.setCreditCard(creditCard);
		customerServive.saveCustomer(customer);
		return customer.getCreditCard();
	}
	
	@PostMapping(value = "/addBankAccount/{customerId}")
	public BankAccount addBankAccount(@Valid @RequestBody BankAccount bankAccount,
			@PathVariable Integer customerId) {
		Customer customer = customerServive.getCustomerById((long) customerId);
		customer.setBankAccount(bankAccount);
		customerServive.saveCustomer(customer);
		return customer.getBankAccount();
	}
	
	@PostMapping(value = "/address/{customerId}")
	public Address addAddress(@Valid @RequestBody Address address,
			@PathVariable Integer customerId) {
		Customer customer = customerServive.getCustomerById((long) customerId);
		customer.setAddress(address);
		customerServive.saveCustomer(customer);
		return customer.getAddress();
	}
	
	@PostMapping(value = "/addDvdToWatchlist/{customerId}")
	public Watchlist addDvdToWatchlist(@Valid @RequestBody DVD dvd,
			@PathVariable Integer customerId) {
		Customer customer = customerServive.getCustomerById((long) customerId);
		Watchlist watchlist = getWatchlist(customer);
		watchlist.addDvdToWatchlist(dvd);
		customer.setWatchlist(watchlist);
		customerServive.saveCustomer(customer);
		return customer.getWatchlist();
	}

	private Watchlist getWatchlist(Customer customer) {
		return customer.getWatchlist() == null ? new Watchlist() : customer.getWatchlist();
		
	}
	
}
