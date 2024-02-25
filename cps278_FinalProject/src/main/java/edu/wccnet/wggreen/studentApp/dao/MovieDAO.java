package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import edu.wccnet.wggreen.studentApp.entity.Movie;

public interface MovieDAO {

	public Movie getMovie(int id);

	public List<Movie> getMovies();

	public List<Movie> searchTitle(String keyword);

	public List<Movie> searchDescription(String keyword);
	
	public Movie getMovieByTitle(String title);

	public void saveMovie(Movie movie);

}
