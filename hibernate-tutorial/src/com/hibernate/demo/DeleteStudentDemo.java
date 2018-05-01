package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			//delete the student
//			System.out.println("Deleting student" + student);
//			session.delete(student);
			
			// delete student id=2
			System.out.println("delete id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();

			
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
