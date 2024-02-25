package edu.wccnet.wggreen.jdbcDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCampusDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			College college = session.get(College.class, 7);

			Campus brightonCampus = new Campus("7878 Brighton Rd.", "Brighton", "MI", "48116");

			college.add(brightonCampus);

			// session.save(college);
			session.persist(college);

			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

}
