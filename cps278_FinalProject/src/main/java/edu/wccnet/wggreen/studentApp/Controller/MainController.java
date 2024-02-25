package edu.wccnet.wggreen.studentApp.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.wggreen.studentApp.Service.CheckoutService;
import edu.wccnet.wggreen.studentApp.Service.CustomerService;
import edu.wccnet.wggreen.studentApp.Service.MovieService;
import edu.wccnet.wggreen.studentApp.entity.Checkout;
import edu.wccnet.wggreen.studentApp.entity.Customer;
import edu.wccnet.wggreen.studentApp.entity.Movie;

@Controller
public class MainController {

	@Autowired
	CustomerService customerService;

	@Autowired
	MovieService movieService;

	@Autowired
	CheckoutService checkoutService;

	@GetMapping("/")
	public String getCustomers(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "customers";
	}

	@GetMapping("/newMovie")
	public String newMovie(Model model) {
		Movie movie = new Movie();

		Map<String, String> ratings = new LinkedHashMap<String, String>();

		ratings.put("G", "G");
		ratings.put("PG", "PG");
		ratings.put("PG-13", "PG-13");
		ratings.put("R", "R");
		ratings.put("NC-17", "NC-17");

		model.addAttribute("ratings", ratings);

		Map<String, String> genres = new LinkedHashMap<>();
		genres.put("Action", "Action");
		genres.put("Animation", "Animation");
		genres.put("Comedy", "Comedy");
		genres.put("Drama", "Drama");
		genres.put("Documentary", "Documentary");
		genres.put("Family", "Family");
		genres.put("Fantasy", "Fantasy");
		genres.put("Horror", "Horror");
		genres.put("Mystery", "Mystery");
		genres.put("Romance", "Romance");
		genres.put("Sci-fi", "Sci-fi");
		genres.put("Thriller", "Thriller");

		model.addAttribute("genres", genres);

		model.addAttribute("movie", movie);
		return "new-movie";
	}

	@PostMapping("/processMovie")
	public String processMovie(@ModelAttribute("movie") Movie movie) {
		movieService.saveMovie(movie);

		return "redirect:/browse";
	}

	@GetMapping("/browse")
	public String getMovies(Model model) {
		Checkout checkout = new Checkout();

		model.addAttribute("checkout", checkout);

		model.addAttribute("movies", movieService.getMovies());
		return "search-movies";
	}

	@RequestMapping("/search")
	public String searchMovies(@RequestParam("searchTerms") String searchTerms,
			@RequestParam(value = "searchType", required = false) String searchType, Model model) {

		Checkout checkout = new Checkout();

		model.addAttribute("checkout", checkout);

		if (searchType != null && !searchType.isEmpty()) {
			if (searchType.equals("title")) {
				List<Movie> searchResults = movieService.searchTitle(searchTerms);
				model.addAttribute("searchResults", searchResults);
			} else if (searchType.equals("description")) {
				List<Movie> searchResults = movieService.searchDescription(searchTerms);
				model.addAttribute("searchResults", searchResults);
			}
		}

		return "results";
	}

	@RequestMapping("/customer")
	public String listCheckouts(Model model, @RequestParam("customerId") int id) {
		model.addAttribute("checkouts", checkoutService.getCheckoutsForCustomer(id));

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		model.addAttribute("customerName", customer.getName());
		model.addAttribute("customerId", id);

		return "checkout-history";
	}

//	

	@PostMapping("/processCheckout")
	public String processCheckout(@ModelAttribute("checkout") Checkout checkout,
			@RequestParam(value = "checkoutId", required = false) Integer checkoutId,
			@RequestParam("movieId") int movieId, @RequestParam("customerId") int customerId) {

		if (checkoutId != null && checkoutId > 0) {
			checkout = checkoutService.getCheckout(checkoutId);
		}

		Movie movie = movieService.getMovie(movieId);
		Customer customer = customerService.getCustomer(customerId);

		checkout.setMovie(movie);
		checkout.setCustomer(customer);

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		if (checkout.getCheckoutDate() == null) {
			checkout.setCheckoutDate(sqlDate);
		} else if (checkout.getReturnDate() == null) {
			checkout.setReturnDate(sqlDate);
		}

		checkoutService.saveCheckout(checkout);

		movie.setAvailableCopies(movie.getAvailableCopies());

		return "redirect:/customer?customerId=" + customerId;
	}

}
