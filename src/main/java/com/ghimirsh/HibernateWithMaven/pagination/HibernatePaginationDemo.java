package com.ghimirsh.HibernateWithMaven.pagination;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ghimirsh.HibernateWithMaven.onetomany.Department;
import com.ghimirsh.HibernateWithMaven.onetomany.Employee;

public class HibernatePaginationDemo {

	public static void main(String[] args) {
		System.out.println("Program execution started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Create Department object
		
		

		//Open Session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Saving Question object
		
		
		
		tx.commit();
		
//		////Fetching data
//		System.out.println("Department1 Info:");
//		System.out.println(dept1.getDepartmentName());
//		for(Employee emp: dept1.getEmployees()) {
//			System.out.println(emp.getFirstName() + ", " + emp.getLastName());
//		}
//		System.out.println("-------------------");
//		System.out.println("Department2 Info:");
//		System.out.println(dept2.getDepartmentName());
//		for(Employee emp: dept2.getEmployees()) {
//			System.out.println(emp.getFirstName() + ", " + emp.getLastName());
//		}
		
		session.close();
		factory.close();

	}

}
