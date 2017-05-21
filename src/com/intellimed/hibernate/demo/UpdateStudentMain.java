package com.intellimed.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.intellimed.hibernate.demo.entity.Student;

public class UpdateStudentMain {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session;
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			int studentId = 15;
			Student student = session.get(Student.class, studentId);
			System.out.println("Retrieving student with ID " + studentId);
			student.setFirstName("Scooby");
			System.out.println("Updating student with ID " + studentId);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email = 'goo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

		
	}

	private static void displayStudents(List<Student> students) {
		for (Student tempStudent : students){
			System.out.println("Retrieved student: " + tempStudent);
		}
	}

}
