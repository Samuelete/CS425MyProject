package edu.mum.cs.cs425.movie.mail.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/list")
	public String getAllCustomerDvds(Model model) {
		Customer customer = customerService.getCustomerById((long) 1);
		 List<DVD> dvds = customer.getDvdListRented();
		model.addAttribute("dvds", dvds);
		model.addAttribute("dvdsCount", dvds.size());
		return "customer/list";
	}
	
}
