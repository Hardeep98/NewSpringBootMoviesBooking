package com.niit.moviebooking.controller;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.services.CustomerService;
import com.niit.moviebooking.services.LoginService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService proser;

	@Autowired
	private LoginService logService;
	
	@RequestMapping("/register")
	public String showForms() {
		return "register-forms";
	}
	
	@RequestMapping("/edit")
	public ModelAndView showEditProductPage(@RequestParam("id") long id) {
		ModelAndView userDetail = new ModelAndView("updateUser");
		Customer cust = logService.get(id);
		System.out.println(cust.getFirstname());
		userDetail.addObject("customer", cust);
		return userDetail;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("customer") Customer customer) {
		proser.save(customer);
		return "userHome";

	}

	@PostMapping("/loginUser")
	public ModelAndView loginCustomer(HttpServletRequest req, @ModelAttribute("customer") Customer cust) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		StringTokenizer st = new StringTokenizer(email, "@");
		String s2 = st.nextToken();

		ModelAndView mav = null;
		Customer d = logService.findByEmail(email);

		if (d == null) {
			mav = new ModelAndView("register-forms");
			mav.addObject("error", "User Doesn't Exists");
		} else if (email.equals(d.getEmail()) && pass.equals(d.getPassword())) {

			req.getSession().setAttribute("user", s2);

			mav = new ModelAndView("userHome");
			mav.addObject("customer", d);
		}

		else {
			mav = new ModelAndView("register-forms");
			mav.addObject("error", "Invalid Username or Password");
		}

		return mav;
	}
}
