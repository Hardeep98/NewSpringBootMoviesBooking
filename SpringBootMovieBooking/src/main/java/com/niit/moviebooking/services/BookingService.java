package com.niit.moviebooking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.moviebooking.model.Booking;
import com.niit.moviebooking.repository.BookMovieRepository;

@Service
@Transactional
public class BookingService {
	@Autowired
	BookMovieRepository bMrepo;
	
	public List<Booking> listAllByUserID(Long id){
		return bMrepo.findAllBycustomerId(id);
	}
	
	public List<Booking> listAll(){
		return bMrepo.findAll();
	}
	public void save(Booking book) {
		bMrepo.save(book);
	}
	public Booking get(int id) {
		return bMrepo.findById(id).get();
	}
	public void delete(int id) {
		bMrepo.deleteById(id);
	}

}
