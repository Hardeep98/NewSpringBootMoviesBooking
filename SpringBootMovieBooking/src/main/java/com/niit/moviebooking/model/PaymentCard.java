package com.niit.moviebooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class PaymentCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int movie_id;
	private int customerId;
	private Date payment_date;
	private String cardNumber;
	private int cvv;
	private Date expirayDate;
	private String nameOnCard;
	private int totalNumberOfTickets;
	private Date movieDate;
	private int totalPayment;
	
	public PaymentCard() {}
	public PaymentCard(int id, int movie_id, int customerId, Date payment_date, String cardNumber, int cvv,
			Date expirayDate, String nameOnCard, int totalNumberOfTickets, Date movieDate, int totalPayment) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.customerId = customerId;
		this.payment_date = payment_date;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expirayDate = expirayDate;
		this.nameOnCard = nameOnCard;
		this.totalNumberOfTickets = totalNumberOfTickets;
		this.movieDate = movieDate;
		this.totalPayment = totalPayment;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}
	public int getTotalNumberOfTickets() {
		return totalNumberOfTickets;
	}
	public void setTotalNumberOfTickets(int totalNumberOfTickets) {
		this.totalNumberOfTickets = totalNumberOfTickets;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Date getExpirayDate() {
		return expirayDate;
	}
	public void setExpirayDate(Date expirayDate) {
		this.expirayDate = expirayDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
}
