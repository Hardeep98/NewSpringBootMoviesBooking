package com.niit.moviebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService proser;
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}
	@RequestMapping("/register")
	public String showForms() {
		return "register-forms";
	}
	
	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("customer") Customer customer) {
		proser.save(customer);
		return "redirect:/register";
		
	}
}
