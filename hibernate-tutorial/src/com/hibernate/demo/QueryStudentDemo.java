package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display students
			displayStudents(theStudents);
			
			//query students: lastName A
			theStudents = session.createQuery("from Student s where s.lastName='A'").getResultList();
			//display students
			System.out.println("with lastName A");
			displayStudents(theStudents);
			
			//query students: lastName A or firstName aaa
			theStudents = 
					session.createQuery("from Student s where "
							+ "s.lastName='A' OR s.firstName='aaa'").getResultList();
			
			//display students
			System.out.println("with lastName=A or firstName=aaa");
			displayStudents(theStudents);
			
			//query students where email like '%@tut.by'
			theStudents = session.createQuery("from Student s where "
			+ "s.email LIKE '%tut.by'").getResultList();
			
			
			System.out.println("email = %tut.by");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
