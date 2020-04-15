package com.niit.moviebooking.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long booking_id;

	private Date bookingDate;

	private int price_movie;

	private int paymentstatus;

	@Column(name = "numberoftickets")
	private int numberOfTickets;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId")
	private Movies movies;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public int getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getPrice_movie() {
		return price_movie;
	}

	public void setPrice_movie(int price_movie) {
		this.price_movie = price_movie;
	}

}
