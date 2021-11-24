package com.ghimirsh.HibernateWithMaven.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToManyDemo {

	public static void main(String[] args) {
		System.out.println("Program execution started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Create Department object
		Department dept1 = new Department();
		dept1.setDepartmentId(101);
		dept1.setDepartmentName("Marketing");
		
		Department dept2 = new Department();
		dept2.setDepartmentId(102);
		dept2.setDepartmentName("Sales");
		
		//Create Employee Objects
		Employee emp1 = new Employee();
		emp1.setEmployeeId(1);
		emp1.setFirstName("Sam");
		emp1.setLastName("Ghimire");
		emp1.setDepartment(dept1);
		
		Employee emp2 = new Employee();
		emp2.setEmployeeId(2);
		emp2.setFirstName("Ram");
		emp2.setLastName("Nepal");
		emp2.setDepartment(dept1);
		
		Employee emp3 = new Employee();
		emp3.setEmployeeId(3);
		emp3.setFirstName("Hari");
		emp3.setLastName("Nepali");
		emp3.setDepartment(dept1);
		
		Employee emp4 = new Employee();
		emp4.setEmployeeId(4);
		emp4.setFirstName("Manish");
		emp4.setLastName("Nepal");
		emp4.setDepartment(dept2);
		
		List<Employee> list1 = new ArrayList<Employee>();
		list1.add(emp1);
		list1.add(emp2);
		list1.add(emp3);
		dept1.setEmployees(list1);
		
		List<Employee> list2 = new ArrayList<Employee>();
		list2.add(emp4);
		dept2.setEmployees(list2);
		

		//Open Session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Saving Question object
		session.save(dept1);
		session.save(dept2);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		
		
		tx.commit();
		
		////Fetching data
		System.out.println("Department1 Info:");
		System.out.println(dept1.getDepartmentName());
		for(Employee emp: dept1.getEmployees()) {
			System.out.println(emp.getFirstName() + ", " + emp.getLastName());
		}
		System.out.println("-------------------");
		System.out.println("Department2 Info:");
		System.out.println(dept2.getDepartmentName());
		for(Employee emp: dept2.getEmployees()) {
			System.out.println(emp.getFirstName() + ", " + emp.getLastName());
		}
		
		session.close();
		factory.close();

	}

}
