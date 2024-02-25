package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.wggreen.studentApp.entity.Checkout;
import edu.wccnet.wggreen.studentApp.entity.Customer;

@Repository
public class CheckoutDAOImpl implements CheckoutDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Checkout getCheckout(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Checkout.class, id);
	}

	@Override
	@Transactional
	public List<Checkout> getCheckoutsForCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer c where id = :customerId ", Customer.class);
		query.setParameter("customerId", customerId);
		Customer customer = query.getSingleResult();

		return customer.getCheckouts();
	}

	@Override
	@Transactional
	public void saveCheckout(Checkout checkout) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(checkout);

	}

}
