package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			Course course1 = new Course("D");
			Course course2 = new Course("E");
			
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
