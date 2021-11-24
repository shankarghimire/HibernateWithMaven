package com.ghimirsh.HibernateWithMaven;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		System.out.println( "Project Started..." );
        ////Method I: (short cut)
        ///SessionFactory  factory = new Configuration().configure().buildSessionFactory();
        //Method II
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
//        
        
        //Saving Student object
        Student std = new Student();
        std.setId(105L);
        std.setFirstName("Sam");
        std.setLastName("Ghimire");
        std.setCity("Toronto");
        
        //Create Certificate object
        Certificate cert = new Certificate("Java","2 Months");     
        std.setCerti(cert);
            
        ////get session
        Session session = factory.openSession();
        Transaction tx =   session.beginTransaction();
        session.save(std); 

        tx.commit();   
        session.close();
        factory.close();
        System.out.println("objects saved to database!");

	}

}
