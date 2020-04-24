package com.niit.moviebooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.niit.moviebooking.controller.PaymentController;
import com.niit.moviebooking.services.PaymentCardService;

public class PaymentControllerTest {

	@Mock
	PaymentController payController;
	@InjectMocks
	PaymentCardService payCardService;
//	
//	@InjectMocks
//	private MovieService mService; 
//	@Mock
//	private BookingService bService; 
	
	@Mock
	HttpServletRequest req;
	@Spy
	Model model;
	
	
	
	@Test
	public void showPayFormTest() {
		verify(payController, times(1)).showPayForm(model);
//		ModelAndView mav = null;
//		when(req.getSession().getAttribute("Uid")).thenReturn(mav=new ModelAndView("payCard"));
//		assertEquals("payCard",payController.showPayForm(model));
//		
	}
	
	
}
