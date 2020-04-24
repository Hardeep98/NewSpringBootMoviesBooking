package com.niit.moviebooking.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.springframework.web.servlet.ModelAndView;

@Entity
@Table(name = "customer")
public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String password;
	private String email;


	public Customer(Long id, String firstname, String password, String email, List<Booking> booking) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.password = password;
		this.email = email;
		this.booking = booking;
	}

	@OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL})
	private List<Booking> booking;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Customer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
