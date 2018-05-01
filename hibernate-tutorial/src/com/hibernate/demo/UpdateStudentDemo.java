package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student on id
			System.out.println("\nstudent with id" + studentId);

			Student student = session.get(Student.class, studentId);

			System.out.println("Update:");
			student.setFirstName("Tooto");

			// commit transaction
			session.getTransaction().commit();

			// new Code

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("upadating emails students's");

			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			// commit transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
