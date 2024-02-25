package edu.wccnet.wggreen.jdbcDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class)
				.addAnnotatedClass(Company.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			College wcc = session.get(College.class, 7);
			Company ellucian = session.get(Company.class, 2);
			Company bb = new Company("Blackboard");

			ellucian.addCollege(wcc);

			wcc.addCompany(bb);
			session.persist(bb);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
