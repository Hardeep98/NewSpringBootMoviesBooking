package com.niit.moviebooking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.moviebooking.model.Movies;
import com.niit.moviebooking.repository.MovieRepository;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository mRepo;
	
	public List<Movies> listAll(){
		return mRepo.findAll();
	}
	
	public void save(Movies movie) {
		mRepo.save(movie);
	}
	public Movies get(int id) {
		return mRepo.findById(id).get();
	}
	public void delete(int id) {
		mRepo.deleteById(id);
	}
	public List<Movies> findByName(String name){
		return mRepo.fetchMovieName(name);
	}
}
