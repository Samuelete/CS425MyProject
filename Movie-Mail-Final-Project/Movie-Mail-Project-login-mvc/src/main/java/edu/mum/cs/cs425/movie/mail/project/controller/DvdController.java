package edu.mum.cs.cs425.movie.mail.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.movie.mail.project.model.Customer;
import edu.mum.cs.cs425.movie.mail.project.model.DVD;
import edu.mum.cs.cs425.movie.mail.project.service.CustomerService;
import edu.mum.cs.cs425.movie.mail.project.service.DvdService;

@Controller
@RequestMapping(value = "/dvd")
public class DvdController {

	@Autowired
	private DvdService dvdService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/list")
	public String getAllDvds(Model model) {
		 List<DVD> dvds = dvdService.getAllDvds();
		model.addAttribute("dvds", dvds);
		model.addAttribute("dvdsCount", dvds.size());
		return "dvd/list";
	}
	
    @GetMapping(value = "/search")
    public ModelAndView searchDvds(@RequestParam String searchDvds) {
        ModelAndView modelAndView = new ModelAndView();
        List<DVD> dvds = dvdService.searchDvds(searchDvds);
        modelAndView.addObject("dvds", dvds);
        modelAndView.addObject("searchDvds", searchDvds);
        modelAndView.addObject("dvdsCount", dvds.size());
        modelAndView.setViewName("dvd/list");
        return modelAndView;
    }
    
	@GetMapping(value = "/shoppingCartCheckout")
	public String shoppingCartCheckout(@RequestParam("dvdId") Long dvdId,
									Model model) {
		
		DVD dvd = dvdService.getDvdById(dvdId);
		model.addAttribute("dvd", dvd);
		
		return "dvd/shoppingcart";			
	}
	
	@PostMapping(value = "/placeorder")
	public String shoppingCartPlaceOrder(@ModelAttribute("dvd") DVD dvd) {
		
		Customer customer = customerService.getCustomerById((long) 1);
		customer.addDvd(dvd);
		customerService.saveCustomer(customer);
		System.out.println(customer);

		return "redirect:/customer/list";			
	}
	
}
