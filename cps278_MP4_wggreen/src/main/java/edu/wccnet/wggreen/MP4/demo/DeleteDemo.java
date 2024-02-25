package edu.wccnet.wggreen.MP4.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).addAnnotatedClass(Pizza.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		Scanner scanner = new Scanner(System.in);

		try {
			session.beginTransaction();

			List<Order> orders = session.createQuery("from Order", Order.class).getResultList();

			System.out.println("\nList of Orders:");
			for (Order order : orders) {
				System.out.println(order.toString());
			}

			System.out.print("\nEnter the ID of the order to delete: ");
			int orderId = scanner.nextInt();

			Order selectedOrder = session.get(Order.class, orderId);

			if (selectedOrder != null) {
				System.out.println("\nDeleting Order #" + selectedOrder.getId() + ":");
				session.delete(selectedOrder);
				System.out.println("Order deleted successfully.");
			} else {
				System.out.println("\nOrder with ID " + orderId + " not found.");
			}

			session.getTransaction().commit();

		} finally {
			scanner.close();
			session.close();
			factory.close();
		}
	}

}
