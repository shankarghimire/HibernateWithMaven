package com.ghimirsh.HibernateWithMaven.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name="department_id")
	private int departmentId;
	private String departmentName;
	
	@OneToMany(mappedBy = "department", fetch=FetchType.EAGER)
	private List<Employee>  employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int departmentId, String departmentName, List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employees = employees;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
//	@Override
//	public String toString() {
//		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
//				+ employees + "]";
//	}
	
	
	

}
