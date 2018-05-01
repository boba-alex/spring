package com.hibernate.demo;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// option 2: Hibernate query with HQL

			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId",
					Instructor.class);

			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query
			Instructor instructor = query.getSingleResult();
			
			System.out.println("lll: Instructor " + instructor);

			// commit transaction
			session.getTransaction().commit();

			session.close();
			System.out.println("\nSession is closed!\n");
			// lazy
			System.out.println("lll: Course:" + instructor.getCourses());

			System.out.println("lll: done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
