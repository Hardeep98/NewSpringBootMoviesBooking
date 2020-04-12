package com.niit.moviebooking.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.repository.CustomerRepository;

@Service
@Transactional
public class LoginService {

	

	@Autowired
	private CustomerRepository custRepo;

	public Customer findByEmail(String email) {
		return custRepo.findByEmail(email);

	}

	public Customer get(long id) {
		return custRepo.findById(id).get();
	}

}
