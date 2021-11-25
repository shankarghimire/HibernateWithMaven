package com.ghimirsh.HibernateWithMaven.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ghimirsh.HibernateWithMaven.onetomany.Department;
import com.ghimirsh.HibernateWithMaven.onetomany.Employee;


public class HQLDemoApp {

	public static void main(String[] args) {
		System.out.println("Program execution started!!!");
		////Configuration for Hibernate
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Open Session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		//HQL Syntax
		//Basic Query
		String query = "from Employee";		
		Query<Employee> q = session.createQuery(query);
		List<Employee> empList = q.list();
		System.out.println("---------Basic Query Demo--------");
		//empList.forEach((emp)->System.out.println(emp));
		
		for(Employee emp: empList) {
			System.out.println(emp.getEmployeeId() +", " + emp.getFirstName() + ", " + emp.getLastName() +", " + emp.getDepartment().getDepartmentName());
		}
		System.out.println("___________________________________");
		
		//Query with where condition
		String query1 = "from Employee where lastName=:p";
		
		Query<Employee> q1 = session.createQuery(query1);
		q1.setParameter("p", "Nepal");
		List<Employee> empList1 = q1.list();
		//empList.forEach((emp)->System.out.println(emp));
		for(Employee emp: empList1) {
			System.out.println(emp.getEmployeeId() +", " + emp.getFirstName() + ", " + emp.getLastName() +", " + emp.getDepartment().getDepartmentName());
		}
		System.out.println("___________________________________");
		////Fetching Department and Employee Info
		
		String query2 = "from Department";
		Query q2 = session.createQuery(query2);
		List<Department> departmentList = q2.list();
		System.out.println();
		System.out.println("-----------------------");
		for(Department d: departmentList) {
			System.out.println(d.getDepartmentId() +", " + d.getDepartmentName());
			System.out.println("Employee Info for this Department: ");
			for(Employee e: d.getEmployees()) {
				System.out.println(e.getEmployeeId() + ", " + e.getFirstName() +", " + e.getLastName());
			}
		}
		System.out.println("___________________________________");
		
		/////Query to Update record
//		String queryToUpdate = "update Employee set "
//				+ "lastName =:newLastName ,"
//				+ "email =:newEmail ,"
//				+ "firstName =:newFirstName "
//				+ " where employeeId =:id";
//		
//		Query updateQuery = session.createQuery(queryToUpdate);
//		updateQuery.setParameter("newLastName", "Ghim");
//		updateQuery.setParameter("newFirstName", "Samriddha");
//		updateQuery.setParameter("newEmail", "sam@gmail.com");
//		updateQuery.setParameter("id", 1);
//		
//		int numberOfUpdatedObjects = updateQuery.executeUpdate();
//		System.out.println("Number of Updated objects/records: " + numberOfUpdatedObjects);
//		System.out.println("___________________________________");
		
		/////Query to delete record
//		String queryToDelete = "delete from Employee where lastName=:c";
//		Query delQuery = session.createQuery(queryToDelete);
//		delQuery.setParameter("c", "Nepal");
//		int numberOfDeletedObjects = delQuery.executeUpdate();
//		System.out.println("Number of deleted objects/records: " + numberOfDeletedObjects);
//		System.out.println("___________________________________");
//		
		
		////HQL Join Demo
		String qryForJoin = "select d.departmentId, d.departmentName, e.firstName, e.lastName, e.email from Department as d INNER JOIN d.employees as e";
		Query joinQuery = session.createQuery(qryForJoin);
		List<Object[]> joinList = joinQuery.list();
		System.out.println("------Join Result between Employee and Department-------");
		for(Object[] e: joinList) {
			//System.out.println(e.getEmployeeId() +", " + e.getFirstName() +", " + e.getLastName() +", " + e.getEmail() +", " + e.getDepartment().getDepartmentName() );
			System.out.println(Arrays.toString(e));
		}
		System.out.println("___________________________________");
		
		
		////Close session and factory object
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Program Execution got stopped....");
	}

}
