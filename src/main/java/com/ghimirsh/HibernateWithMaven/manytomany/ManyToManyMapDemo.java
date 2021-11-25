package com.ghimirsh.HibernateWithMaven.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMapDemo {

	public static void main(String[] args) {
		System.out.println("Program execution started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create Author object
		Author auth1 = new Author();
		auth1.setAuthorId(101);
		auth1.setAuthorName("Ram Nepal");
		auth1.setAuthorEmail("ram@gmail.com");

		Author auth2 = new Author();
		auth2.setAuthorId(102);
		auth2.setAuthorName("Hari Nepal");
		auth2.setAuthorEmail("hari@gmail.com");

		Author auth3 = new Author();
		auth3.setAuthorId(103);
		auth3.setAuthorName("Manish");
		auth3.setAuthorEmail("manish@gmail.com");

		// Create Book Object
		Book book1 = new Book();
		book1.setBookId(501);
		book1.setTitle("Java Guides");
		book1.setPrice(98.15);

		Book book2 = new Book();
		book2.setBookId(502);
		book2.setTitle("Hibernate Guides");
		book2.setPrice(11.15);

		Book book3 = new Book();
		book3.setBookId(503);
		book3.setTitle("SQL Guides");
		book3.setPrice(33.15);

		//// Books Authors data
		List<Author> book1Authors = new ArrayList<Author>();
		book1Authors.add(auth1);
		book1Authors.add(auth2);

		List<Author> book2Authors = new ArrayList<Author>();
		book2Authors.add(auth1);
		book2Authors.add(auth2);

		List<Author> book3Authors = new ArrayList<Author>();
		book3Authors.add(auth3);

		List<Book> author1Books = new ArrayList<Book>();
		author1Books.add(book1);
		author1Books.add(book2);

		List<Book> author2Books = new ArrayList<Book>();
		author2Books.add(book1);
		author2Books.add(book2);

		List<Book> author3Books = new ArrayList<Book>();
		author3Books.add(book3);

		//// Setting authors to books
		book1.setAuthors(book1Authors);
		book2.setAuthors(book2Authors);
		book3.setAuthors(book3Authors);

		//// Setting Books to Authors
		auth1.setBooks(author1Books);
		auth2.setBooks(author2Books);
		auth3.setBooks(author3Books);

		// Open Session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Saving Book objects
		session.save(book1);
		session.save(book2);
		session.save(book3);

		// Saving Authors objects
		session.save(auth1);
		session.save(auth2);
		session.save(auth3);

		tx.commit();

		//// Fetching data
		//// Book-01
		Book b1 = (Book) session.get(Book.class, 501);
		System.out.println("Book Info: ");
		System.out.println("Bookd Id: " + b1.getBookId());
		System.out.println("Title : " + b1.getTitle());
		System.out.println("Price : " + b1.getPrice());
		System.out.println("Authors Infor: ");
		for (Author auth : b1.getAuthors()) {
			System.out.println(auth.getAuthorName());
		}
		System.out.println("------------------------");

		//// Book-02
		Book b2 = (Book) session.get(Book.class, 502);
		System.out.println("Book Info: ");
		System.out.println("Bookd Id: " + b2.getBookId());
		System.out.println("Title : " + b2.getTitle());
		System.out.println("Price : " + b2.getPrice());
		System.out.println("Authors Infor: ");
		for (Author auth : b2.getAuthors()) {
			System.out.println(auth.getAuthorName());
		}
		System.out.println("------------------------");
		//// Book-03
		Book b3 = (Book) session.get(Book.class, 503);
		System.out.println("Book Info: ");
		System.out.println("Bookd Id: " + b3.getBookId());
		System.out.println("Title : " + b3.getTitle());
		System.out.println("Price : " + b3.getPrice());
		System.out.println("Authors Infor: ");
		for (Author auth : b3.getAuthors()) {
			System.out.println(auth.getAuthorName());
		}
		System.out.println("------------------------");
		
		////Fetching Author Info with their books
		System.out.println();
		Author a1 = (Author)session.get(Author.class, 101);
		System.out.println("Author Info:");
		System.out.println("Authord Id: " + a1.getAuthorId());
		System.out.println("Author Name: " + a1.getAuthorName());
		System.out.println("Book Info:");
		for(Book b: a1.getBooks()) {
			System.out.println("Book Id: " + b.getBookId());
			System.out.println("Title : " + b.getTitle());
			System.out.println("Price : "  + b.getPrice());
		}
		System.out.println("------------------------");
		
		System.out.println();
		Author a2 = (Author)session.get(Author.class, 102);
		System.out.println("Author Info:");
		System.out.println("Authord Id: " + a2.getAuthorId());
		System.out.println("Author Name: " + a2.getAuthorName());
		System.out.println("Book Info:");
		for(Book b: a2.getBooks()) {
			System.out.println("Book Id: " + b.getBookId());
			System.out.println("Title : " + b.getTitle());
			System.out.println("Price : "  + b.getPrice());
		}
		System.out.println("------------------------");
		System.out.println();
		Author a3 = (Author)session.get(Author.class, 103);
		System.out.println("Author Info:");
		System.out.println("Authord Id: " + a3.getAuthorId());
		System.out.println("Author Name: " + a3.getAuthorName());
		System.out.println("Book Info:");
		for(Book b: a3.getBooks()) {
			System.out.println("Book Id: " + b.getBookId());
			System.out.println("Title : " + b.getTitle());
			System.out.println("Price : "  + b.getPrice());
		}
		System.out.println("------------------------");
		session.close();
		factory.close();

	}

}
