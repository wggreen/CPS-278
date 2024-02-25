package edu.wccnet.wggreen.jdbcDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Campus ypsiCampus = session.get(Campus.class, 4);

			session.remove(ypsiCampus);

			// session.save(college);

			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

}
