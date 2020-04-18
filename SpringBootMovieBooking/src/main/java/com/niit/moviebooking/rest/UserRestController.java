package com.niit.moviebooking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class UserRestController {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@GetMapping("/customers")
	public List<Customer> getAllUsers(){
		return custRepo.findAll();
	}
	@GetMapping("/customers/total")
	public int getTotalUsers() {
		return (int)(custRepo.count());
	}

}
