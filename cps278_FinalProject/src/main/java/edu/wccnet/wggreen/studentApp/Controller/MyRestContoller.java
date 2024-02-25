package edu.wccnet.wggreen.studentApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.wggreen.studentApp.Service.CheckoutService;
import edu.wccnet.wggreen.studentApp.Service.CustomerService;
import edu.wccnet.wggreen.studentApp.Service.MovieService;
import edu.wccnet.wggreen.studentApp.entity.Checkout;
import edu.wccnet.wggreen.studentApp.entity.Customer;
import edu.wccnet.wggreen.studentApp.entity.Movie;

@RestController
@RequestMapping("/api")
public class MyRestContoller {

	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private MovieService movieService;

	@GetMapping("/movie/{title}")
	public Movie searchMovie(@PathVariable String title) {
		return movieService.getMovieByTitle(title);
	}

	@GetMapping("/checkout/{customerId}")
	public List<Checkout> getCheckoutsByCustomerId(@PathVariable int customerId) {
		return checkoutService.getCheckoutsForCustomer(customerId);
	}

	@ExceptionHandler
	public ResponseEntity<MyAPIErrorResponse> handleException(NotFoundException e) {
		MyAPIErrorResponse error = new MyAPIErrorResponse();

		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<MyAPIErrorResponse> handleException(Exception e) {
		MyAPIErrorResponse error = new MyAPIErrorResponse();

		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
