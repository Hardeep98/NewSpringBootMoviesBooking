package com.niit.moviebooking.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int id;

	private String moviename;
	private String description;

	private Date realesedate;

	private Date enddate;

	private String starcast;
	private String timing;
	private double price;
	private String posterlink;

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
