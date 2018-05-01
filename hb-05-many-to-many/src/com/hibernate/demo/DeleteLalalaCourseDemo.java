package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class DeleteLalalaCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int courseId = 16;
			
			Course course = session.get(Course.class, courseId);
			
			System.out.println("Delete" + course);
			
			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}