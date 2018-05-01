package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("Create");
			Student tempStudent = new Student("faa", "raa", "rrr@tut.by");

			// start a transaction
			session.beginTransaction();

			// save student object
			System.out.println("save");
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
