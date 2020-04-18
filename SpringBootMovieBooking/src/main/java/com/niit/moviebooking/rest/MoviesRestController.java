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
import com.niit.moviebooking.model.Movies;
import com.niit.moviebooking.repository.MovieRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class MoviesRestController {

	@Autowired
	private MovieRepository movieRepo;

	@GetMapping("/movies")
	public List<Movies> getAllMovies() {
		return movieRepo.findAll();
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity<Movies> getProductById(@PathVariable(value = "id") int mId) throws ResourceNotFoundException {
		Movies movie = movieRepo.findById(mId)
				.orElseThrow(() -> new ResourceNotFoundException("Movies not found for this id :: " + mId));
		return ResponseEntity.ok().body(movie);
	}

	@PostMapping("/movies")
	public Movies saveMovie(@Valid @RequestBody Movies movie) {
		return movieRepo.save(movie);
	}

	@DeleteMapping("/movies/{id}")
	public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") int mId) throws ResourceNotFoundException {
		Movies movie = movieRepo.findById(mId)
				.orElseThrow(() -> new ResourceNotFoundException("Movies not found for this id :: " + mId));
		movieRepo.delete(movie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/movies/{id}")
	public  ResponseEntity<Movies> updateMovies(@PathVariable(value = "id") int mId,@Valid @RequestBody Movies m) throws ResourceNotFoundException{
		Movies movies = movieRepo.findById(mId).orElseThrow(() -> new ResourceNotFoundException("Movies not found for this id :: " + mId));
		movies.setDescription(m.getDescription());
		movies.setEnddate(m.getRealesedate());
		movies.setMovieback(m.getMovieback());
		movies.setMoviename(m.getMoviename());
		movies.setPosterlink(m.getPosterlink());
		movies.setStarcast(m.getStarcast());
		movies.setPrice(m.getPrice());
		movies.setRealesedate(m.getRealesedate());
		movies.setTiming(m.getTiming());
		final Movies updateMovie=movieRepo.save(movies);
		return ResponseEntity.ok(updateMovie);
		
		
		
	}
}
