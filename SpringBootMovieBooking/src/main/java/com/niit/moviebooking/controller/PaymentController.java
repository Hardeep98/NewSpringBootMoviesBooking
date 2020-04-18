package com.niit.moviebooking.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.moviebooking.model.Customer;

import com.niit.moviebooking.model.PaymentCard;

import com.niit.moviebooking.repository.PaymentCardRepository;
import com.niit.moviebooking.services.LoginService;
import com.niit.moviebooking.services.MovieService;

@Controller
public class PaymentController {
	@Autowired
	private PaymentCardRepository pcRepo;
	
	@Autowired
	private MovieService mService;
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	private LoginService logService;
	
	@RequestMapping("/pay")
	public ModelAndView showPayForm(Model model)  {
		Long Uid;
		ModelAndView mav = null;
		if(req.getSession().getAttribute("Uid")!=null)
		{	
			mav=new ModelAndView("payCard");
			Uid = Long.parseLong(req.getSession().getAttribute("Uid").toString());
			Customer cust = logService.get(Uid);
			model.addAttribute("customername", cust.getFirstname());
			mav.addObject("customer", cust);
			System.out.println(cust.getFirstname());
			int mid = (Integer.parseInt(req.getSession().getAttribute("sMovieId").toString()));
			model.addAttribute("mId", mid);
		}	
		else
			mav=new ModelAndView("redirect:/register");
		return mav;
		
		
	}
	@RequestMapping("/payCard")
	public ModelAndView payCard(@RequestParam("id") int movie_id,Model m) {
		ModelAndView mav = null;
		PaymentCard card=new PaymentCard();

		int custId=0;
		if(req.getSession().getAttribute("Uid").toString()!=null){
			custId=Integer.parseInt(req.getSession().getAttribute("Uid").toString());
		}
		if(req.getSession().getAttribute("Uid").toString()==null  && movie_id==0) {
			mav = new ModelAndView("redirect:/");
			m.addAttribute("booked",0);
			
		}
		mav = new ModelAndView("redirect:/");
		m.addAttribute("booked",1);
		card.setCustomerId(custId);
		card.setMovie_id(movie_id);
		card.setPayment_date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		pcRepo.save(card);
		return mav;
	}

}
