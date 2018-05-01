package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("Create");
			Student tempStudent = new Student("D", "A", "rrr@tut.by");

			// start a transaction
			session.beginTransaction();

			// save student object
			System.out.println("save: " + tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			
			//MY NEW CODE
			
			//find out the student's id: primary key
			System.out.println("Saved student" + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student on id
			System.out.println("\nstudent with id"+ tempStudent.getId());
			
			Student student = session.get(Student.class, tempStudent.getId());
			
			System.out.println("complete:" + student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done!");			
		} 
		finally {
			factory.close();
		}
	}

}
