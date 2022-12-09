package com.jdbcdemo.entity;

public class Employee {
	
	private int id;
	private String last_Name;
	private String first_Name;
	private String email;
	private String department;
	private double salry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalry() {
		return salry;
	}
	public void setSalry(double salry) {
		this.salry = salry;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", last_Name=" + last_Name + ", first_Name=" + first_Name + ", email=" + email
				+ ", department=" + department + ", salry=" + salry + "]";
	}
	

}
