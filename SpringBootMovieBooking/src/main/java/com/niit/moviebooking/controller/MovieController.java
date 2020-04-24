package com.niit.moviebooking.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.moviebooking.model.Booking;
import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.model.Movies;
import com.niit.moviebooking.services.BookingService;
import com.niit.moviebooking.services.LoginService;
import com.niit.moviebooking.services.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService mService;

	@Autowired
	private LoginService logService;

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private BookingService bs;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		int id=0;
		// ModelAndView userDetail = new ModelAndView("index");
		if (req.getSession().getAttribute("Uid") != null) {
			id = Integer.parseInt(req.getSession().getAttribute("Uid").toString());
			if (id > 0) {
				Customer cust = logService.get(id);
				model.addAttribute("id", cust.getId());
				model.addAttribute("customername", cust.getFirstname());
				System.out.println(cust.getFirstname());

			}
		}
		System.out.println(id);
		List<Movies> totMovies = mService.listAll();
		
		model.addAttribute("listMovies", totMovies);
		model.addAttribute("user", 1);

		return "index";
	}
	

	@RequestMapping("/selectSeat")
	public String selectSeat() {
		return "SelectSeat";
	}
	@RequestMapping("/movieDeatil")
	public ModelAndView showMovieDetail(@RequestParam("mid") int id, Model model) {
		int Uid = 0;
		if (req.getSession().getAttribute("Uid") != null) {
			Uid = Integer.parseInt(req.getSession().getAttribute("Uid").toString());
			if (Uid > 0) {
				Customer cust = logService.get(Uid);
				model.addAttribute("id", cust.getId());
				model.addAttribute("customername", cust.getFirstname());

			}
		}
		req.getSession().setAttribute("sMovieId", id);
		ModelAndView MovieDetail = new ModelAndView("MovieDetail");
		Movies movie = mService.get(id);
		System.out.println(movie.getMoviename());
		MovieDetail.addObject("movies", movie);

		return MovieDetail;
	}
	
	@RequestMapping("/serchMovie")
	public ModelAndView serchMovie(HttpServletRequest req,Model m)
	{
		int Uid = 0;
		if (req.getSession().getAttribute("Uid") != null) {
			Uid = Integer.parseInt(req.getSession().getAttribute("Uid").toString());
			if (Uid > 0) {
				Customer cust = logService.get(Uid);
				m.addAttribute("id", cust.getId());
				m.addAttribute("customername", cust.getFirstname());

			}
		}
		String name=req.getParameter("movieName");
		System.out.println("name is "+name);
		List<Movies> movie=mService.findByName(name);
		
		ModelAndView mv=new ModelAndView("serchResult");
		mv.addObject("movieList",movie);
		return mv;
	}

	@RequestMapping(value = "/BookMovie", method = RequestMethod.POST)
	public String bookMovie(@ModelAttribute("booking") Booking book,Model m) {
		
		Customer cust=null;
		int mid = (Integer.parseInt(req.getSession().getAttribute("sMovieId").toString()));
		int Uid = 0;
		Movies movie = mService.get(mid);
		if (req.getSession().getAttribute("Uid") != null) {
			Uid = Integer.parseInt(req.getSession().getAttribute("Uid").toString());
			if (Uid > 0) {
				cust = logService.get(Uid);
				Uid = Integer.parseInt((cust.getId().toString()));
			}
			int price = (int) (movie.getPrice());
			book.setMovies(movie);
			book.setPrice_movie(price);
			book.setNumberOfTickets(1);
			book.setPaymentstatus(1);
			book.setCustomer(cust);
			m.addAttribute("price",price);
			
			book.setBookingDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
			bs.save(book);
			return "redirect:/pay";
		} else if (Uid == 0) {
			return "redirect:/register";
		}

		return "redirect:/";

	}
}
