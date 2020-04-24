package com.niit.moviebooking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	
	
	public List<Customer> listInfo() {
		return customerRepo.findAll();
	}
	
	public void save(Customer cust) {
		customerRepo.save(cust);
	}
	
	public Customer get(long id) {
		return customerRepo.findById(id).get();
		
	}
	public void delete(long id) {
		customerRepo.deleteById(id);
	}
	
}
