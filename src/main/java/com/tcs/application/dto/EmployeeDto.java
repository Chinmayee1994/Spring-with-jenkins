package com.tcs.application.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable{

	private static final long serialVersionUID = -623978265090497438L;
	
	private String empName;
	private String designation;
	private String department;
	private double salary;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
