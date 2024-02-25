package edu.wccnet.wggreen.MP4.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Customer customer1 = session.get(Customer.class, 7);

			Order order1 = new Order(customer1);

			Pizza order1Pizza1 = new Pizza("Small", "Anchovies");

			order1.add(order1Pizza1);;

			session.persist(order1);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}

	}

}
