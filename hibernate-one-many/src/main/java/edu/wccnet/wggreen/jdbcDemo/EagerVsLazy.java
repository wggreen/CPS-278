package edu.wccnet.wggreen.jdbcDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerVsLazy {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			College college = session.get(College.class, 7);

			// session.save(college);

			System.out.println(college);

			session.getTransaction().commit();

			System.out.println(college.getCampuses());

		} finally {
			session.close();
		}
	}

}
