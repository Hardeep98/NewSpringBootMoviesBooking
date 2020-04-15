package com.niit.moviebooking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.moviebooking.model.PaymentCard;
import com.niit.moviebooking.repository.PaymentCardRepository;

@Service
@Transactional
public class PaymentCardService {

	@Autowired
	private PaymentCardRepository paymentCardRepository;
	
	public List<PaymentCard> listInfo(){
		return paymentCardRepository.findAll();
	}
	public void save(PaymentCard payment) {
		paymentCardRepository.save(payment);
		
	}
	public PaymentCard get(int id) {
		return paymentCardRepository.findById(id).get();
	}
	public void delete(int id) {
		paymentCardRepository.deleteById(id);
	}
	
}
