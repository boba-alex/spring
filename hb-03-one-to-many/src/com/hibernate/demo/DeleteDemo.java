package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			
			// start a transaction
			session.beginTransaction();

			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("Found instructor:" + instructor);
			
			if(instructor != null) {
				System.out.println("Deleting instructor..." + instructor);
				
				// will delete details too!
				session.delete(instructor);
			}
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
