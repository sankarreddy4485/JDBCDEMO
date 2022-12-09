package com.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.Role;
import com.jdbcdemo.entity.Employee;

public class MySqlOperation implements CRUDOperation {
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	@Override
	public Connection getConnection() throws SQLException {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "DataGuard432$");

			System.out.println("Database connection successful!\n");

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return myConn;
	}

	
	@Override
	public int addNewEmployee(Employee employee) throws SQLException {
		myConn = this.getConnection();
		String insertQuery = "INSERT INTO EMPLOYEES(id,last_name,first_name,email,department,salary)"
				+ "values(?,?,?,?,?,?)";
		myStmt = myConn.prepareStatement(insertQuery);
		myStmt.setInt(1, employee.getId());
		myStmt.setString(2, employee.getLast_Name());
		myStmt.setString(3, employee.getFirst_Name());
		myStmt.setString(4, employee.getEmail());
		myStmt.setString(5, employee.getDepartment());
		myStmt.setDouble(6, employee.getSalry());
		int rowid = myStmt.executeUpdate();
		if (rowid > 0) {
			System.out.println("The Company details inserted successfully with Emp Id" + employee.getId());
			return employee.getId();
		}
		return rowid;
	}

	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		myConn = this.getConnection();
		myStmt = myConn.prepareStatement("select * from employees");

		myRs = myStmt.executeQuery();

		// 4. Process the result set
		while (myRs.next()) {
			Employee employee = new Employee();
			employee.setId(myRs.getInt("id"));
			employee.setLast_Name(myRs.getString("last_name"));
			employee.setFirst_Name(myRs.getString("first_name"));
			employee.setEmail(myRs.getString("email"));
			employee.setDepartment(myRs.getString("department"));
			employee.setSalry(myRs.getDouble("salary"));
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public void searchEmployee(int id) throws SQLException {
		this.getEmployeeList().stream().filter(emp -> emp.getId() == id).forEach(System.out::println);		
	}

	@Override
	public void deleteEmployee(int empId) throws SQLException {
		myConn = this.getConnection();
		myStmt = myConn.prepareStatement("delete from employees where id=?");
		myStmt.setInt(1, empId);
		int rowdeleted = myStmt.executeUpdate();
		if (rowdeleted > 0) {
			System.out.println("The Employee details deleted for EmpId " + empId);
			
		}		
		
	}

	@Override
	public int updateEmployee(Employee emp) throws SQLException {
		int rowid;
		try {
			myConn = this.getConnection();
		
		String updateQuery = "Update demo.user set username='SIVA_USER' where username='SIVA_ADMIN'";
		myStmt = myConn.prepareStatement(updateQuery);
		/*
		 * myStmt.setString(1, emp.getLast_Name()); myStmt.setInt(2, emp.getId());
		 */
		
		rowid = myStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SQLException();
		}
		return rowid;
	}


	@Override
	public Role validateUserDeatils(String username) throws SQLException {
		Role role = new Role();
		myConn = this.getConnection();
		myStmt = myConn.prepareStatement("select * from USER where username=?");
		myStmt.setString(1, username);
		myRs = myStmt.executeQuery();
		while (myRs.next()) {
		role.setUserName(myRs.getString("userName"));
		role.setPassword(myRs.getString("password"));
		role.setRole(myRs.getString("role"));
		}
		return role;
		
	}

}
