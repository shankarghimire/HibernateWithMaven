package com.ghimirsh.HibernateWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemoApp {

	public static void main(String[] args) {
		System.out.println("Project Started...");
		//// Method I: (short cut)
		/// SessionFactory factory = new
		//// Configuration().configure().buildSessionFactory();
		// Method II
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		
		Session session = factory.openSession();
       
		//Get Student: 104
		//Student student = (Student)session.get(Student.class, 104L);
		Student student = (Student)session.load(Student.class, 104L);
		System.out.println(student);
		
		//Get Address
		Address adr = (Address)session.get(Address.class, 1);
		System.out.println(adr);
		
		
        session.close();
        factory.close();
        System.out.println("objects retrieved from database!");

	}

}
