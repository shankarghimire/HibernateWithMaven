package com.ghimirsh.HibernateWithMaven.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapDemo {

	public static void main(String[] args) {
		
		System.out.println("Program execution started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		////Creates Question object
		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("What is Java?");
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(501);
		ans1.setAnswer("It's the most popular programming language.");
		ans1.setQuestion(q1);
		
		q1.setAnswer(ans1);
		
		
		
		//Open Session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Saving Question object
		session.save(q1);
		session.save(ans1);
		
		
		tx.commit();
		
		////Fetching data
		Question tempQ = (Question)	session.get(Question.class, 101);
		System.out.println(tempQ.getQuestionId());
		System.out.println( tempQ.getQuestion());
		System.out.println(tempQ.getAnswer().getAnswerId());
		System.out.println(tempQ.getAnswer().getAnswer());
		
		session.close();
		factory.close();
		
		

	}

}
