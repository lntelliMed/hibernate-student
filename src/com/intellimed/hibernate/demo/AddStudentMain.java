package com.intellimed.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.intellimed.hibernate.demo.entity.Student;

public class AddStudentMain {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student student = new Student("FirstName1", "LastName1", "someemailaddress1@somedomainname.com");
		
		try {
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

		
	}

}
