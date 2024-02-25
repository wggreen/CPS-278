package edu.wccnet.wggreen.studentApp.entity;

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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "checkout")
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "checkout_date")
	private Date checkoutDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "return_date")
	private Date returnDate;
	
	public Checkout() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Checkout [id=" + id + ", customer=" + customer + ", movie=" + movie + ", checkoutDate=" + checkoutDate
				+ ", returnDate=" + returnDate + "]";
	}

	public Checkout(Customer customer, Movie movie, Date checkoutDate, Date returnDate) {
		super();
		this.customer = customer;
		this.movie = movie;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
	}
	
	
}
