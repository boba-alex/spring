package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create
			/*
			 * Instructor instructor = new Instructor("sasa", "dada", "eee@tut.by");
			 * 
			 * InstructorDetail instructorDetail = new InstructorDetail("youtube",
			 * "hobby1");
			 */

			Instructor instructor = new Instructor("sSSasa", "dSSada", "eeSSe@tut.by");

			InstructorDetail instructorDetail = new InstructorDetail("youSStube", "hoSSbby1");

			instructor.setInstructorDetail(instructorDetail);
			// start a transaction
			session.beginTransaction();

			// also saves details because CascadeType.ALL
			System.out.println("instructor" + instructor);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
