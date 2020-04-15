package com.niit.moviebooking.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.moviebooking.model.Booking;



public interface BookMovieRepository extends JpaRepository<Booking,Integer> {
	public List<Booking> findAllBycustomerId(Long id);
}
