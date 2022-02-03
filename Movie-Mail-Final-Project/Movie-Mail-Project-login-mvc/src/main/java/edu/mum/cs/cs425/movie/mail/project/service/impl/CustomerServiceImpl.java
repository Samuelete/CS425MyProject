package edu.mum.cs.cs425.movie.mail.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.repository.CustomerRepository;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.getById(customerId);
	}

}
