package edu.mum.cs.cs425.movie.mail.project.service;

import java.util.List;

import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.model.Order;

public interface CustomerService {

	public abstract Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(Long customerId);
	public abstract void addNewOrder(Customer customer, Order order);
}
