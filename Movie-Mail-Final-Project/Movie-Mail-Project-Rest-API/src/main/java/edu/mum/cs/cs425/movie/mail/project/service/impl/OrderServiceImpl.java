package edu.mum.cs.cs425.movie.mail.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.movie.mail.project.model.Order;
import edu.mum.cs.cs425.movie.mail.project.repository.CustomerRepository;
import edu.mum.cs.cs425.movie.mail.project.repository.OrderRepository;
import edu.mum.cs.cs425.movie.mail.project.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersByCustomerId(Long customerId) {
		
		List<Order> orders = orderRepository.findAll();
		
		for(Order order: orders) {
			if(order.getCustomer().getCustomerId() == customerId) {
				return order.getCustomer().getListOrdersCustomer();
			}
		}
		
		return null;
	}

}
