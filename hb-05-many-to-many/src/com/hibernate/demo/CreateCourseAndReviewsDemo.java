package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			Course course = new Course("Java");
			
			course.addReview(new Review("Great!"));
			course.addReview(new Review("Good!"));
			course.addReview(new Review(")))"));
			
			
			System.out.println("Saving");
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.save(course);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
