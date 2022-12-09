package com.jdbcdemo.dao;


import java.sql.SQLException;
import java.util.List;

import com.jdbcdemo.Role;
import com.jdbcdemo.entity.Employee;

public interface CRUDOperation extends DBConnection{

	public int addNewEmployee(Employee employee) throws SQLException;
	public List<Employee> getEmployeeList() throws SQLException;
	public void searchEmployee(int id) throws SQLException;
	public void deleteEmployee(int empId) throws SQLException;
	public int updateEmployee(Employee emp) throws SQLException;
	public Role validateUserDeatils(String username) throws SQLException;
	
	
}
