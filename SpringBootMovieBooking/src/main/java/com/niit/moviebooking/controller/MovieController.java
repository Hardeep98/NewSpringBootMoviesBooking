package com.niit.moviebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.moviebooking.model.Movies;
import com.niit.moviebooking.services.MovieService;

@Controller
public class MovieController {

	@Autowired 
	private MovieService mService;
	
	@RequestMapping("/")
	public String showHomePage(Model model) {
		
		List<Movies> totMovies=mService.listAll();
		model.addAttribute("listMovies", totMovies);
		
		return "index";
	}
	
}
