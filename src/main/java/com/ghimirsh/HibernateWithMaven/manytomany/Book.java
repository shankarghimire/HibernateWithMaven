package com.ghimirsh.HibernateWithMaven.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	@Column(name="book_id")
	private int bookId;
	private String title;
	private int publicationYear;
	private double price;
	
	//@ManyToMany(mappedBy = "books")//Creates author_book table
	@ManyToMany
	@JoinTable
	(
			name="book_author_link",
			joinColumns = {@JoinColumn(name="b_id")},
			inverseJoinColumns = {@JoinColumn(name="a_id")}
	)
	private List<Author>authors;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String title, int publicationYear, double price, List<Author> authors) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publicationYear = publicationYear;
		this.price = price;
		this.authors = authors;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publicationYear=" + publicationYear + ", price="
				+ price + ", authors=" + authors + "]";
	}
	

}
