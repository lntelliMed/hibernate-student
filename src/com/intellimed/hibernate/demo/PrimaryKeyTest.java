package com.intellimed.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.intellimed.hibernate.demo.entity.Student;

public class PrimaryKeyTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session;
		try{
			for (int i = 0; i<10; i++){
				Student student = new Student("FirstName"+i, "LastName"+i, "someemailaddress"+i+"@somedomainname.com");
				session = factory.getCurrentSession();
				session.beginTransaction();
				session.save(student);
				session.getTransaction().commit();
			}
		} finally {
			factory.close();
		}
	}

}
