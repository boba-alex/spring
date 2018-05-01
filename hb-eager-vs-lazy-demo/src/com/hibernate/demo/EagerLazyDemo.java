package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			System.out.println("lll: Instructor " + instructor);
			
			//lazy option 1: load then we can use it next
			System.out.println("lll: Course:" + instructor.getCourses());
			
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\nSession is closed!\n");
			//lazy
			System.out.println("lll: Course:" + instructor.getCourses());
			
			System.out.println("lll: done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
