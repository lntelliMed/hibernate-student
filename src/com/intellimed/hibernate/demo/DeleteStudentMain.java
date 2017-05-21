package com.intellimed.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.intellimed.hibernate.demo.entity.Student;

public class DeleteStudentMain {

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
			
			System.out.println("Deleting student with ID " + studentId);
			Student student = session.get(Student.class, studentId);
			session.delete(student);
			
			System.out.println("Deleting student with ID 16");
			session.createQuery("delete from Student where id = 16").executeUpdate();
			
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
