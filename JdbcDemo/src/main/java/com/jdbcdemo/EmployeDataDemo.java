package com.jdbcdemo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jdbcdemo.dao.CRUDOperation;
import com.jdbcdemo.dao.MySqlOperation;
import com.jdbcdemo.entity.Employee;

public class EmployeDataDemo {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		// Liskov Priniciple to get connection based on Database
		CRUDOperation mySqlOperation = new MySqlOperation();
		Employee employee = new Employee();

		System.out.println("Enter UserName");
		String username = scanner.next();
		Role role = mySqlOperation.validateUserDeatils(username);
		if (role.getRole().equalsIgnoreCase("Admin")) {

			System.out.println("welcome admin:" + "[\r\n" + "1. add a new Employee,\r\n" + "2. see all employee,\r\n"
					+ "3. search an employee,\r\n" + "4. delete an employee,\r\n" + "5. update an employee\r\n" + "]");
			int number = scanner.nextInt();

			switch (number) {
			case 1:
				System.out.println("Enter new Employee form");
				System.out.println("Enter Emp Id");
				employee.setId(scanner.nextInt());
				System.out.println("Enter Emp last_Name");
				employee.setLast_Name(scanner.next());
				System.out.println("Enter Emp First_Name");
				employee.setFirst_Name(scanner.next());
				System.out.println("Enter Emp email");
				employee.setEmail(scanner.next());
				System.out.println("Enter Emp Department");
				employee.setDepartment(scanner.next());
				System.out.println("Enter Emp Salary");
				employee.setSalry(scanner.nextDouble());
				int empId = mySqlOperation.addNewEmployee(employee);
				System.out.println("New Employee inserted successfully with Id: " + empId);
				break;
			case 2:

				List<Employee> employees = mySqlOperation.getEmployeeList();
				employees.stream().forEach(System.out::println);
				break;
			case 3:
				System.out.println("Enter Emp id for Search operation ");
				employee.setId(scanner.nextInt());
				mySqlOperation.searchEmployee(employee.getId());
				break;
			case 4:
				System.out.println("Enter Emp id for delete operation ");
				employee.setId(scanner.nextInt());
				mySqlOperation.deleteEmployee(employee.getId());
				break;
			case 5:
				System.out.println("Enter Emp id for for updation");
				employee.setId(scanner.nextInt());
				System.out.println("Enter Emp name for for updation");
				employee.setLast_Name(scanner.next());
				int updatedId = mySqlOperation.updateEmployee(employee);
				if (updatedId > 0) {
					System.out
							.println("The Employeedetails details updated successfully with Emp Id" + employee.getId());
				} else {
					System.out.println(
							"The Employeedetails details not updated successfully with Emp Id" + employee.getId());
				}

				break;
			default:
				System.out.println("Exit from the app");
			}
		} else if (role.getRole().equalsIgnoreCase("USER")) {

			System.out.println("welcome USER:" + "[\r\n" + "1. View All Employee,\r\n" + "2. Your Profile ,\r\n"
					+ "3. search an employee,\r\n" + "]");
			int number = scanner.nextInt();
			switch (number) {
			case 1:
				List<Employee> employees = mySqlOperation.getEmployeeList();
				employees.stream().forEach(System.out::println);
				break;
			case 2:
				Role profile = mySqlOperation.validateUserDeatils(username);
				System.out.println("User Profile:" + profile);
				break;
			case 3:
				System.out.println("Enter Emp id for Search operation ");
				employee.setId(scanner.nextInt());
				mySqlOperation.searchEmployee(employee.getId());
				break;
			default:
				System.out.println("Exit from the app");
			}
		}
	}
}
