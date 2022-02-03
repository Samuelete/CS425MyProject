package edu.mum.cs.cs425.movie.mail.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

	@GetMapping(value = {"/", "/home"})
	public String displayHomePage() {
		return "home/index";
	}
	
}
