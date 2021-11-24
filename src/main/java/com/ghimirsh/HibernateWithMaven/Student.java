package com.ghimirsh.HibernateWithMaven;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String city;
	
	private Certificate certi;
	
	public Student() {
		super();	
	}
	

	public Student(Long id, String firstName, String lastName, String city, Certificate certi) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.certi = certi;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Certificate getCerti() {
		return certi;
	}


	public void setCerti(Certificate certi) {
		this.certi = certi;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", certi=" + certi + "]";
	}


	
	
}
