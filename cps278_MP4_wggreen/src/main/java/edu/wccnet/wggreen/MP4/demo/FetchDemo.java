package edu.wccnet.wggreen.MP4.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);

		try {
			session.beginTransaction();

			List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();

			System.out.println("\nList of Customers:");
			for (Customer customer : customers) {
				System.out.println(customer.toString());
			}

			System.out.print("\nEnter the ID of the customer to view their orders: ");
			int customerId = scanner.nextInt();

			Customer selectedCustomer = session.get(Customer.class, customerId);

			if (selectedCustomer != null) {
				System.out.println("\nOrders for Customer #" + selectedCustomer.getId() + ":");
				for (Order order : selectedCustomer.getOrders()) {
					System.out.println(order.toString());
				}
			} else {
				System.out.println("\nCustomer with ID " + customerId + " not found.");
			}

			session.getTransaction().commit();

		} finally {
			scanner.close();
			session.close();
			factory.close();
		}

	}

}
