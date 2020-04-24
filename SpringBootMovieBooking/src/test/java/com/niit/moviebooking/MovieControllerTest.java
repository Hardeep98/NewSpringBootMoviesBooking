package com.niit.moviebooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;

import com.niit.moviebooking.controller.MovieController;
import com.niit.moviebooking.model.Booking;
import com.niit.moviebooking.model.Customer;
import com.niit.moviebooking.model.Movies;
import com.niit.moviebooking.services.BookingService;
import com.niit.moviebooking.services.MovieService;


public class MovieControllerTest {
	@InjectMocks
	MovieController mController;
	
	
	@InjectMocks
	private MovieService mService;
	
	@Mock
	private BookingService bService; 
	
	@Mock
	Movies movieDao;
	@Spy
	Model model;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	
	
	 
	@Mock 
	private HttpServletRequest req;
	@Mock 
	Date d;
	@Test
	public void bookMovieTest() {
		
		Booking book=new Booking();
		book.setBooking_id(1L);
		book.setBookingDate(d);
		book.setCustomer(new Customer());
		book.setMovies(new Movies());
		book.setNumberOfTickets(2);
		book.setPaymentstatus(1);
		book.setPrice_movie(200);
		bService.save(book);
		when((req.getSession().getAttribute("Uid"))).thenReturn("redirect:/");
		//System.out.println(val);
		verify(bService, times(1)).save(book);
		assertEquals(mController.bookMovie(book, model), "redirect:/");
		//assertEquals("redirect:/pay", mController.bookMovie(book, model));

		
	}
	@Spy
	List<Booking> booking;
	@Test
	public void showHomePageTest() {
		List<Movies> movie=new ArrayList<Movies>();
		Movies m1=new Movies(1, "BloodShort", "Good Movie",new Date(2020/24/4), new Date(2020/30/4), "Vin Diesel", "10 pm", 200, "look.jpg","look2.jpg",booking);
		Movies m2=new Movies(2, "legmore", "Acrtion Movie",new Date(2020/24/4), new Date(2020/30/4), "dasd", "12 pm", 200, "look.jpg","look2.jpg",booking);
		Movies m3=new Movies(1, "looka", "lstia Movie",new Date(2020/24/4), new Date(2020/30/4), "Asssssssssssssssssasd", "10 pm", 200, "look.jpg","look2.jpg",booking);
		
		movie.add(m1);
		movie.add(m2);
		movie.add(m3);
		mService.save(m1);
		
		//when(mService.listAll()).thenReturn(movie);
		List<Movies> movi2=mService.listAll();
		//assertEquals(3, movi2.size());
		//verify(mService,times(1)).listAll();
		//System.out.println(movi2.size()); 
		when(mController.showHomePage(model)).thenReturn("index");
		
	}
}
