package com.niit.moviebooking.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.moviebooking.exception.ResourceNotFoundException;
import com.niit.moviebooking.model.Booking;
import com.niit.moviebooking.repository.BookMovieRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/book")
public class BookingRestController {

	@Autowired
	private BookMovieRepository bkRepo;

	@GetMapping("/booking")
	public List<Booking> getAllBookings() {
		return bkRepo.findAll();
	}

	@GetMapping("booking/{id}")
	public ResponseEntity<Booking> getBookById(@PathVariable(value = "id") Long bId) throws ResourceNotFoundException {
		Booking book = bkRepo.findById(bId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking Not Found this ID:: " + bId));
		return ResponseEntity.ok().body(book);
	}

	@PostMapping("booking")
	public Booking saveBook(@Valid @RequestBody Booking book) {
		return bkRepo.save(book);
	}

	@DeleteMapping("/booking/{booking_id}")
	public Map<String, Boolean> deleteBook(@PathVariable(value = "booking_id") Long bId) throws ResourceNotFoundException {
		Booking book = bkRepo.findById(bId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + bId));
		bkRepo.delete(book);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return response;

	}

	@PutMapping("/booking/{booking_id}")
	public ResponseEntity<Booking> updateBook(@PathVariable(value = "booking_id") Long bId, @Valid @RequestBody Booking b)
			throws ResourceNotFoundException {
		Booking book = bkRepo.findById(bId)
				.orElseThrow(() -> new ResourceNotFoundException("Data not found for this id :: " + bId));
		book.setBookingDate(b.getBookingDate());
		book.setCustomer(b.getCustomer());
		book.setMovies(b.getMovies());
		book.setNumberOfTickets(b.getNumberOfTickets());
		book.setPaymentstatus(b.getPaymentstatus());
		book.setPrice_movie(b.getPrice_movie());
		final Booking updateBook = bkRepo.save(book);
		return ResponseEntity.ok(updateBook);

	}
}
