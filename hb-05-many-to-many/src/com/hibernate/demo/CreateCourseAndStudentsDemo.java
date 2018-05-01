package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			Course course = new Course("Java12");
			
			System.out.println("saving the course");
			session.save(course);
			System.out.println("saved the course" + course);
			
			Student student1 = new Student("A", "B", "@dsjfhd");
			Student student2 = new Student("C", "D", "@dsjfhd");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
			System.out.println(course.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
