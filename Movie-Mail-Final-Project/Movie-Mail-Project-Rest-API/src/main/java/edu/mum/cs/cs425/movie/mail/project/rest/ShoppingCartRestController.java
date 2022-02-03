package edu.mum.cs.cs425.movie.mail.project.rest;

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
import edu.mum.cs.cs425.movie.mail.project.model.ShoppingCart;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;
import edu.mum.cs.cs425.movie.mail.project.service.ShoppingCartService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:8080"}, allowedHeaders = "*")
@RequestMapping(value = "/api/shoppingcart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	public ShoppingCartRestController(CustomerService customerService, ShoppingCartService shoppingCartService) {
		this.customerService = customerService;
		this.shoppingCartService = shoppingCartService;
	}

	@PostMapping(value = "/addDvd/{customerId}") 
	public ShoppingCart addDvdToCart(@Valid @RequestBody DVD dvd,
			@PathVariable Long customerId) {
		
		Customer customer = customerService.getCustomerById(customerId);
		
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(isShoppingCartEmpty(customer));
		
		if(dvd != null) {
			shoppingCartService.addDvdToCart(shoppingCart, dvd);
		}
		
		shoppingCartService.saveShoppingCart(shoppingCart);
		
		return shoppingCart;
	}

	@PostMapping(value = "/removeDvd/{shoppingCartId}/{dvdId}") 
	public ShoppingCart removeDvdToCart(@PathVariable Long shoppingCartId, 
			@PathVariable Long dvdId) {
		
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(shoppingCartId);
		shoppingCartService.removeDvdToCart(shoppingCart, dvdId);
		shoppingCartService.saveShoppingCart(shoppingCart);
		return shoppingCart;
	}
	
	@GetMapping(value = "/getCart/{shoppingCartId}")
	public ShoppingCart getShoppingCart(@PathVariable Long shoppingCartId) {
		return shoppingCartService.getShoppingCartById(shoppingCartId);
	}
	
	@PostMapping(value = "/clearCart/{shoppingCartId}")
	public ShoppingCart clearShoppingCart(@PathVariable Long shoppingCartId) {
		
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(shoppingCartId);
		
		shoppingCartService.cleanShoppingCart(shoppingCart);
		
		return shoppingCartService.saveShoppingCart(shoppingCart);
		
	}
	
	private Long isShoppingCartEmpty(Customer customer) {
			if(customer.getShoppingCart() == null) {
				return createShoppingCart(customer);
			}
		return customer.getShoppingCart().getShoppingCardId();
	}

	private Long createShoppingCart(Customer customer) {
		ShoppingCart shoppingCart = new ShoppingCart();
		customer.setShoppingCart(shoppingCart);
		customerService.saveCustomer(customer);
		customer = customerService.getCustomerById(customer.getCustomerId());
		return customer.getShoppingCart().getShoppingCardId();
		
	}

}
