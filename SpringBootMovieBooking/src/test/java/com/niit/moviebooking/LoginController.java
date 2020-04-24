package com.niit.moviebooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.niit.moviebooking.controller.CustomerController;
import com.niit.moviebooking.model.Booking;
import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.services.BookingService;
import com.niit.moviebooking.services.CustomerService;
import com.niit.moviebooking.services.LoginService;

public class LoginController {

	@InjectMocks
	CustomerController cust;

	@Mock
	private CustomerService custSer;

	@Mock
	private LoginService loginSer;
	@Mock
	private BookingService bkSer;


	@Spy
	Model model;
	@Spy
	ModelAndView mav;
	@Spy
	Customer customer;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}
	
	@Spy
	Booking book;
	@Test
	public void cancelTicketTest() { // customer= loginSer.get(8);
		when(bkSer.get(1L)).thenReturn(book);
		book.setPaymentstatus(0);
		bkSer.save(book);
		verify(bkSer,times(1)).save(book);
		
		assertEquals(cust.cancelTicket(1L), "redirect:/cancelticketPage");
	}
	

	@Spy
	List<Booking> lBook;
	
	@Test
	public void viewUserDetailTest() {
		
		
		Customer cust1=new Customer(1L, "Hardeep Singh", "1234", "hardeepsinghdahion",lBook);
		when(custSer.get(1L)).thenReturn(cust1);
		Customer cust2=custSer.get(1L);
		//when(req.getSession().getAttribute("Uid")).thenReturn(model.addAttribute("customername",cust1.getFirstname()));
		
		//mav=cust.viewUserDetail(model);
		mav= new ModelAndView("UserBookingDetail");
		assertEquals("Hardeep Singh",cust2.getFirstname());
		assertEquals("hardeepsinghdahion",cust2.getEmail() );
	
		assertEquals("UserBookingDetail", mav.getViewName());
	}
	
	
	@Test 
	public void showEditUserPageTest() {
		Customer cust1=new Customer(1L, "Hardeep Singh", "1234", "hardeepsinghdahion",lBook);
		when(loginSer.get(1L)).thenReturn(cust1);
		mav=cust.showEditUserPage(1L);
		assertEquals(cust1,mav.getModel().get("customer"));
		assertEquals("updateUser",mav.getViewName());
		
		
	}
	
//	@Test 
//	public void showCancelTicketPageTest() {
//		HttpSession session = mock(HttpSession.class);
//		when(req.getSession()).thenReturn(session);
//		when(req.getSession().getAttribute("Uid")).thenReturn(1L);
////		when(lBook).thenReturn(bkSer.listAllByUserID(1L));
//		mav = new ModelAndView("CancelTicket");
//		//assertEquals(lBook,mav.getModel().get("bookingDetail"));
//		assertEquals(mav,cust.cancelTicketPage(model) );
//		
//	}
	@Test
	public void addUserTest() {
		Customer cust1 = new Customer();
		cust1.setId(1L);
		cust1.setEmail("hardeepsinghdahion@gmail.com");
		cust1.setFirstname("Hardeep Singh");
		cust1.setPassword("1234");
		custSer.save(cust1);
		verify(custSer, times(1)).save(cust1);
		assertEquals("register-forms", cust.saveUser(cust1, model));

	}

	@Test
	public void loginCustomerTest() {
		String email = "hardeepsinghdahion@gmail.com";
		Customer c1 = new Customer();
		c1.setEmail("hardeepsinghdahion@gmail.com");
		c1.setPassword("123456");
		
		
		
		when(loginSer.findByEmail(email)).thenReturn(c1);
		Customer c2 = loginSer.findByEmail("hardeepsinghdahion@gmail.com");
		assertEquals(c2.getEmail(), "hardeepsinghdahion@gmail.com");
		assertEquals(c2.getPassword(), "123456");
		
	}

	@Mock
	HttpServletRequest req;
	@Spy
	HttpSession ses;

	@Test
	public void logoutUserTest() {

		when(req.getSession()).thenReturn(ses);
		assertEquals(cust.logout(req), "redirect:/");
	}



}
