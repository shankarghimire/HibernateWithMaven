package com.ghimirsh.HibernateWithMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
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
        std.setId(104L);
        std.setFirstName("Sam");
        std.setLastName("Ghimire");
        std.setCity("Toronto");
        
        ////Creating Address Object
        Address adr = new Address();
        adr.setStreet("41, Bernard Ave.");
        adr.setCity("Brampton");
        adr.setOpen(true);
        adr.setAddedDate(new Date());
        adr.setX(3.14);
        
        ////Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/p1.jpg");
        byte[] data = new byte[fis.available()];
        adr.setImage(data);
        
        fis.close();
        
           
        //System.out.println(factory);     
        ////get session
        //Session session = factory.getCurrentSession();
        Session session = factory.openSession();
        Transaction tx =   session.beginTransaction();
        session.save(std); 
        session.save(adr);
        tx.commit();
        //session.getTransaction().commit();    
        session.close();
        factory.close();
        System.out.println("objects saved to database!");
    }
}
