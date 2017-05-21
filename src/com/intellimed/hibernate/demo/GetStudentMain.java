package com.intellimed.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.intellimed.hibernate.demo.entity.Student;

public class GetStudentMain {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			System.out.println("\n\n");
			students = session.createQuery("from Student s where s.email like '%com'").getResultList();		
			displayStudents(students);
			System.out.println("\n\n");
			students = session.createQuery("from Student s where s.firstName like 'First%' or s.lastName like 'Last%'").getResultList();		
			displayStudents(students);
			
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
