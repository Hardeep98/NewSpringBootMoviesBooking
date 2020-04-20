package com.niit.moviebooking.controller;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.moviebooking.model.Booking;
import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.services.BookingService;
import com.niit.moviebooking.services.CustomerService;
import com.niit.moviebooking.services.LoginService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService proser;

	@Autowired
	private LoginService logService;
	
	@Autowired
	private BookingService bookSer;
	

	
	@Autowired
	private HttpServletRequest req;
	
	@RequestMapping("/register")
	public String showForms(Model m) {
		
		return "register-forms";
	}
	
	@RequestMapping("/cancelticketPage")
	public ModelAndView cancelticket(Model model) {
		Long Uid;
		ModelAndView mav = null;
		if(req.getSession().getAttribute("Uid")!=null)
		{
			Uid = Long.parseLong(req.getSession().getAttribute("Uid").toString());
			Customer cust = logService.get(Uid);
			model.addAttribute("customername", cust.getFirstname());
			System.out.println(cust.getFirstname());
			
		}	
		else 
		{
			mav=new ModelAndView("register-forms");
			return mav;
		}
		List<Booking> b=bookSer.listAllByUserID(Uid);
		mav = new ModelAndView("CancelTicket");
		mav.addObject("bookingDetail",b);
		 
		return mav;
	}
	@RequestMapping("/cancelticket")
	public String cancelTicket(@RequestParam("bookid") Long id) {
		Booking b=bookSer.get(id);
		b.setPaymentstatus(0);
		bookSer.save(b);
		return "redirect:/cancelticketPage";
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
	public String saveProduct(@ModelAttribute("customer") Customer customer,Model m) {
		proser.save(customer);
		m.addAttribute("callFunc",1);
		return "register";

	}

	@RequestMapping("/userDashboard")
	public ModelAndView userDashboard(Model model) {
		Long Uid;
		ModelAndView mav = null;
		if(req.getSession().getAttribute("Uid")!=null)
		{	
			mav=new ModelAndView("userHome");
			Uid = Long.parseLong(req.getSession().getAttribute("Uid").toString());
			Customer cust = logService.get(Uid);
			model.addAttribute("customername", cust.getFirstname());
			mav.addObject("customer", cust);
			System.out.println(cust.getFirstname());
		
		}	
		else
		{
			mav=new ModelAndView("register-forms");
		}
			
			return mav;
	}
	
	@RequestMapping("/userBookingDetail")
	public ModelAndView viewUserDetail(Model model) {
		Long Uid;
		ModelAndView mav = null;
		if(req.getSession().getAttribute("Uid")!=null)
		{
			Uid = Long.parseLong(req.getSession().getAttribute("Uid").toString());
			Customer cust = logService.get(Uid);
			model.addAttribute("customername", cust.getFirstname());
			System.out.println(cust.getFirstname());
			
		
		}	
		else 
		{
			mav=new ModelAndView("register-forms");
			return mav;
		}
		List<Booking> b=bookSer.listAllByUserID(Uid);
		mav = new ModelAndView("UserBookingDetail");
		mav.addObject("bookingDetail",b);
		
		
		return mav;
	}
	
	@PostMapping("/loginUser")
	public ModelAndView loginCustomer(HttpServletRequest req, @ModelAttribute("customer") Customer cust,Model m) {
		
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
			//sessi.setAttribute("Uid", d.getId());
			
			mav = new ModelAndView("userHome");
			mav.addObject("customer", d);
		}

		else {
			m.addAttribute("report",1);
			mav = new ModelAndView("register-forms");
			mav.addObject("error", "Invalid Username or Password");
		}
		req.getSession().setAttribute("Uid", d.getId());
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}
}
