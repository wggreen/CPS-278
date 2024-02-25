package edu.wccnet.wggreen.studentApp.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private int year;

	@Column(name = "length")
	private int length;

	@Column(name = "genre")
	private String genre;

	@Column(name = "release_date")
	private Date releaseDate;

	@Column(name = "rating")
	private String rating;

	@Column(name = "description")
	private String description;

	@Column(name = "total_copies")
	private int totalCopies;

	@Transient
	private int availableCopies;

	@JsonIgnore
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Checkout> checkouts = new ArrayList<Checkout>();

	public int getAvailableCopies() {
		int checkedOutCopies = 0;

		for (Checkout checkout : checkouts) {
			if (checkout.getReturnDate() == null) {
				checkedOutCopies++;
			}
		}

		return totalCopies - checkedOutCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	public List<Checkout> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}

	public Movie() {

	}

	public void add(Checkout checkout) {
		checkouts.add(checkout);
		checkout.setMovie(this);
	}

	public void remove(Checkout rental) {
		checkouts.remove(rental);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public List<Checkout> getMovieRentals() {
		return checkouts;
	}

	public void setMovieRentals(List<Checkout> movieRentals) {
		this.checkouts = movieRentals;
	}

	public int isCheckedOutByCustomer(int customerId) {
		for (Checkout checkout : checkouts) {
			if (checkout.getCustomer().getId() == customerId && checkout.getMovie().getId() == this.id) {
				if (checkout.getReturnDate() == null) {
					return checkout.getId();
				}
			}
		}
		return 0;
	}
	
	public Movie(String title, int year, int length, String genre, Date releaseDate, String rating, String description,
			int totalCopies, int availableCopies) {
		super();
		this.title = title;
		this.year = year;
		this.length = length;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.description = description;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", length=" + length + ", genre=" + genre
				+ ", releaseDate=" + releaseDate + ", rating=" + rating + ", description=" + description
				+ ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies + ", checkouts=" + checkouts
				+ "]";
	}

}
