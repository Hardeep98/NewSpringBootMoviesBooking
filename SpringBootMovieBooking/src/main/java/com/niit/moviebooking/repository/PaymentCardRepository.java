package com.niit.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.moviebooking.model.PaymentCard;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, Integer> {
	
}
