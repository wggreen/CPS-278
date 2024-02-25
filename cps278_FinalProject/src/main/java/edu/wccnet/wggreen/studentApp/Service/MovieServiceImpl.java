package edu.wccnet.wggreen.studentApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.Controller.NotFoundException;
import edu.wccnet.wggreen.studentApp.dao.MovieDAO;
import edu.wccnet.wggreen.studentApp.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	@Override
	@Transactional
	public Movie getMovie(int id) {
		Movie movie = movieDAO.getMovie(id);

		if (movie == null) {
			throw new NotFoundException("movie id not found. Id: " + id);
		}

		return movie;
	}

	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public List<Movie> searchTitle(String keyword) {
		return movieDAO.searchTitle(keyword);
	}

	@Override
	@Transactional
	public List<Movie> searchDescription(String keyword) {
		return movieDAO.searchDescription(keyword);
	}

	@Override
	@Transactional
	public void saveMovie(Movie movie) {
		movieDAO.saveMovie(movie);

	}

	@Override
	@Transactional
	public Movie getMovieByTitle(String title) {
		return movieDAO.getMovieByTitle(title);
	}

}
