package com.niit.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.moviebooking.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Long> {
	
	public Customer findByEmail(String email);
}
