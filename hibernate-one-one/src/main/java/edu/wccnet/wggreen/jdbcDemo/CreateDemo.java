package edu.wccnet.wggreen.jdbcDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(College.class)
				.addAnnotatedClass(CollegeAddress.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			College college = new College("WCC");
			CollegeAddress collegeAddress = new CollegeAddress("4000 East Huron River Dr.", "Ann Arbor", "MI", "48105");
			
			college.setCollegeAddress(collegeAddress);
			
			//session.save(college);
			session.persist(college);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
