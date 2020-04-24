package com.niit.moviebooking.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieId")
	private int id;

	@Column(name="movieName")
	private String moviename;
	
	private String description;

	private Date realesedate;

	private Date enddate;

	private String starcast;
	private String timing;
	private double price;
	private String posterlink;
	private String movieback;
	public Movies() {}
	public Movies(int id, String moviename, String description, Date realesedate, Date enddate, String starcast,
			String timing, double price, String posterlink, String movieback, List<Booking> booking) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.description = description;
		this.realesedate = realesedate;
		this.enddate = enddate;
		this.starcast = starcast;
		this.timing = timing;
		this.price = price;
		this.posterlink = posterlink;
		this.movieback = movieback;
		this.booking = booking;
	}

	@OneToMany(mappedBy = "movies",cascade= {CascadeType.ALL})
	private List<Booking> booking;
	
	public String getMovieback() {
		return movieback;
	}

	public void setMovieback(String movieback) {
		this.movieback = movieback;
	}

	/* Getter and setter */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRealesedate() {
		return realesedate;
	}

	public void setRealesedate(Date realesedate) {
		this.realesedate = realesedate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStarcast() {
		return starcast;
	}

	public void setStarcast(String starcast) {
		this.starcast = starcast;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPosterlink() {
		return posterlink;
	}

	public void setPosterlink(String posterlink) {
		this.posterlink = posterlink;
	}

}
