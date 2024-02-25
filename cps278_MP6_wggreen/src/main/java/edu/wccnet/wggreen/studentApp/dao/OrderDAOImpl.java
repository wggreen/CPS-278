package edu.wccnet.wggreen.studentApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.wggreen.studentApp.entity.Customer;
import edu.wccnet.wggreen.studentApp.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> getOrders(int customerId) {
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer c where id = :customerId ", Customer.class);
		query.setParameter("customerId", customerId);
		Customer customer = query.getSingleResult();

		return customer.getOrders();
	}

	public void saveOrder(Order theOrder) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theOrder);

	}

	public Order getOrder(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Order.class, id);

	}

	public void deleteOrder(int id) {
		Session session = sessionFactory.getCurrentSession();

		Order order = session.get(Order.class, id);

		session.remove(order);
	}

}
