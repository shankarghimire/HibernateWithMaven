package com.ghimirsh.HibernateWithMaven.NativeQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.ghimirsh.HibernateWithMaven.onetomany.Employee;

public class NativeQueryDemo {

	public static void main(String[] args) {
		System.out.println("Program execution started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Create Department object
		
		

		//Open Session
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
		
		String qry = "select * from employee";
		NativeQuery sqlQuery = session.createSQLQuery(qry);
		
		List<Object[]> list = sqlQuery.list();
		for(Object[] e: list) {
			//System.out.println(Arrays.toString(e));
			System.out.println(e[0] +", " + e[2] +", "+ e[3]);
		}
		
		
//		tx.commit();
		
		session.close();
		factory.close();
		System.out.println("Program execution ended!");

	}

}
