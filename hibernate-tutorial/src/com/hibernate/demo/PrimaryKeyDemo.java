package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create 3 student objects
			System.out.println("Create 3 st");
			Student tempStudent1 = new Student("aaa", "Fa", "a@tut.by");
			Student tempStudent2 = new Student("bbb", "Fo", "b@tut.by");
			Student tempStudent3 = new Student("Ccc", "Fu", "c@tut.by");

			// start a transaction
			session.beginTransaction();

			// save student object
			System.out.println("save");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

}
