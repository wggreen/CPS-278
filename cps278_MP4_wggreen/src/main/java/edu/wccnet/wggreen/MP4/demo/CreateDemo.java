package edu.wccnet.wggreen.MP4.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Customer customer1 = new Customer("John", "Doe", "123 Main St,", "Ann Arbor", "MI", "48103");
			Customer customer2 = new Customer("Jane", "Doe", "124 Main St,", "Ann Arbor", "MI", "48103");

			session.persist(customer1);
			session.persist(customer2);

			Order order1 = new Order(customer1);
			Order order2 = new Order(customer2);

			Pizza order1Pizza1 = new Pizza("Large", "Pepperoni");
			Pizza order1Pizza2 = new Pizza("Small", "Cheese");
			Pizza order2Pizza1 = new Pizza("Medium", "Sausage");

			order1.add(order1Pizza1);
			order1.add(order1Pizza2);
			order2.add(order2Pizza1);

			session.persist(order1);
			session.persist(order2);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
