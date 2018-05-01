package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor detail
			int theId = 222;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			System.out.println("details" + instructorDetail);
			// print associated instructor
			System.out.println("associated instructor " + instructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();// NO LEAKS
			factory.close();
		}
	}

}
