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
import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:8080"}, allowedHeaders = "*")
@RequestMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {

	@Autowired
	private CustomerService customerServive;
	
	@PostMapping(value = "/placeorder/{dvdId}")
	public List<DVD> customerDvds(@Valid @RequestBody DVD dvd,
			@PathVariable Integer dvdId) {
		
		Customer customer = customerServive.getCustomerById((long) dvdId);
		customer.addDvd(dvd);
		customerServive.saveCustomer(customer);
		System.out.println(customer);
		System.out.println(customer);
		System.out.println(customer);
		
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
	
	@PostMapping(value = "/test")
	public String testing() {
		return "TESTING METHOD";
	}
	
}
