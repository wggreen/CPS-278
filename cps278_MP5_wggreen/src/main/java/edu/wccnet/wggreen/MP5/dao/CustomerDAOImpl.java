package edu.wccnet.wggreen.MP5.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.MP5.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers(String sort) {
		Session session = sessionFactory.getCurrentSession();
		
		if (sort == null) {
			sort = "last_name";
		}

		Query<Customer> query = session.createQuery("from Customer order by " + sort, Customer.class);

		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Customer.class, id);

	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
