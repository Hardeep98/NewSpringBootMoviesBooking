package com.niit.moviebooking.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.model.Movies;
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
	public ModelAndView showPayForm(Model model) {
		Long Uid;
		ModelAndView mav = null;
		if (req.getSession().getAttribute("Uid") != null) {
			mav = new ModelAndView("payCard");
			Uid = Long.parseLong(req.getSession().getAttribute("Uid").toString());
			Customer cust = logService.get(Uid);
			model.addAttribute("customername", cust.getFirstname());
			mav.addObject("customer", cust);
			int mid = (Integer.parseInt(req.getSession().getAttribute("sMovieId").toString()));
			model.addAttribute("mId", mid);
		} else
			mav = new ModelAndView("redirect:/register");
		return mav;

	}

	@PostMapping(value = "/payCard")
	public ModelAndView payCard(@RequestParam("id") int movieId, HttpServletRequest req,
			@ModelAttribute("paymentcard") PaymentCard pcard, Model m) {

		ModelAndView mav = null;
		PaymentCard card = new PaymentCard();
		String cardnumber = req.getParameter("cardNumber");
		Date movieDate = Date.valueOf(req.getParameter("bookingDate"));
		String numberOfTicktes = req.getParameter("numberoftickets");
		String cardHolderName = req.getParameter("nameOnCard");
		String cardExpirayDate = req.getParameter("expirayDate");
		String cvv = req.getParameter("cvv");
		int totalAmount = Integer.parseInt(req.getParameter("numberoftickets"));

		int custId = 0;
		if (req.getSession().getAttribute("Uid").toString() != null) {
			custId = Integer.parseInt(req.getSession().getAttribute("Uid").toString());
			Movies mov=mService.get(movieId);
			totalAmount=(totalAmount*(int)(mov.getPrice()));
			
			
		}
		if (req.getSession().getAttribute("Uid").toString() == null ) {
			mav = new ModelAndView("redirect:/");
			m.addAttribute("booked", 0);

		}
		mav = new ModelAndView("redirect:/");
		m.addAttribute("booked", 1);
		card.setCardNumber(cardnumber);
		card.setExpirayDate(Date.valueOf(cardExpirayDate));
		card.setNameOnCard(cardHolderName);
		card.setCvv(Integer.parseInt(cvv));
		card.setTotalNumberOfTickets(Integer.parseInt(numberOfTicktes));
		card.setMovieDate(movieDate);
		card.setCustomerId(custId);
		card.setMovie_id(movieId);
		card.setTotalPayment(totalAmount);
		card.setPayment_date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		System.out.println("movie id" + movieId + "card number is " + cardnumber + "\n movie date " + movieDate
				+ "\n number of tickets:" + numberOfTicktes + "\n cardHolderName:" + cardHolderName
				+ "\ncardExpirayDate" + cardExpirayDate + "\ncvv:" + cvv + "\totalAmount" + totalAmount);
		pcRepo.save(card);
		return mav;
	}

}
