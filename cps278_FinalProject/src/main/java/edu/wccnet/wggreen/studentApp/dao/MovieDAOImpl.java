package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.entity.Customer;
import edu.wccnet.wggreen.studentApp.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Movie getMovie(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Movie.class, id);
	}

	@Override
	@Transactional
	public List<Movie> getMovies() {
		Session session = sessionFactory.getCurrentSession();

		Query<Movie> query = session.createQuery("from Movie order by title", Movie.class);

		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Movie> searchTitle(String keyword) {
		Session session = sessionFactory.getCurrentSession();

	    Query<Movie> query = session.createQuery("From Movie where title like :keyword", Movie.class);
	    query.setParameter("keyword", "%" + keyword + "%");

	    return query.getResultList();
	}

	@Override
	@Transactional
	public List<Movie> searchDescription(String keyword) {
		Session session = sessionFactory.getCurrentSession();

	    Query<Movie> query = session.createQuery("From Movie where description like :keyword", Movie.class);
	    query.setParameter("keyword", "%" + keyword + "%");

	    return query.getResultList();
	}

	@Override
	@Transactional
	public void saveMovie(Movie movie) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(movie);

	}

	@Override
	@Transactional
	public Movie getMovieByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();

		Query<Movie> query = session.createQuery("from Movie m where title = :title ", Movie.class);
		query.setParameter("title", title);
		Movie movie = query.getSingleResult();
		
		return movie;
	}

}
