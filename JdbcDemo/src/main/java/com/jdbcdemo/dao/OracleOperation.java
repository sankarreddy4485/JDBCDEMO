package com.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jdbcdemo.Role;
import com.jdbcdemo.entity.Employee;

public class OracleOperation implements CRUDOperation {

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int empId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateEmployee(Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role validateUserDeatils(String username) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
