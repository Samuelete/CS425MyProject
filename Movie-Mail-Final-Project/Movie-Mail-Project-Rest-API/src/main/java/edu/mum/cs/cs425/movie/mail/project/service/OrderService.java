package edu.mum.cs.cs425.movie.mail.project.service;

import java.util.List;
import edu.mum.cs.cs425.movie.mail.project.model.Order;

public interface OrderService {
	public abstract Order saveOrder(Order order);
	public abstract List<Order> getOrdersByCustomerId(Long CustomerId);
}
