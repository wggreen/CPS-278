package edu.wccnet.wggreen.jdbcDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(Campus.class).addAnnotatedClass(Company.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			College eastern = new College("Eastern Michigan University");

			Company ellucian = new Company("Ellucian");
			Company canvas = new Company("Canvas");

			session.persist(canvas);
			session.persist(ellucian);
			session.persist(eastern);

			eastern.addCompany(canvas);
			eastern.addCompany(ellucian);

			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

}
