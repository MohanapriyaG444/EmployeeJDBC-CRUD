package controller;

import dao.EmployeeDAO;
import model.Employee;

import java.io.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, NumberFormatException, IOException {
		Employee emp=new Employee();
		EmployeeDAO empdao=new EmployeeDAO();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int option;
		System.out.println("____________________________________EMPLOYEE APPLICATION____________________________________");
		do {
				
				
				System.out.println("Menu");
				System.out.println("1.Add Employee");
				System.out.println("2.Display Employee Details");
				System.out.println("3.Update Employee Details");
				System.out.println("4.Delete Employee");
				System.out.println("5.Exit");
				option=Integer.parseInt(br.readLine());
		
		switch(option) {
		case 1:
			System.out.println("Enter the details to be inserted");
			
			System.out.println("Enter employee id");
			int id=Integer.parseInt(br.readLine());
			System.out.println("Enter employee username");
			String username = br.readLine();
			System.out.println("Enter employee password");
			String password = br.readLine();
			System.out.println("Enter employee fullname");
			String fullname = br.readLine();
			System.out.println("Enter employee Email");
			String email = br.readLine();
			System.out.println("Enter employee mobile number");
			long mobileno=Long.parseLong(br.readLine());
			
			emp.setID(id);
			emp.setUSERNAME(username);
			emp.setPASSWORD(password);
			emp.setFULLNAME(fullname);
			emp.setEMAIL(email);
			emp.setMOBILE_NUMBER(mobileno);
			
			
			empdao.addEmployee(emp);
			System.out.println("Employee Added Successfully");
			System.out.println("_______________________________________________________");
			break;
		case 2:
			do {
				System.out.println("1.Select All Employees");
				System.out.println("2.Select Employee by username");
				System.out.println("3.Exit");
				option=Integer.parseInt(br.readLine());
			
			switch(option) {
			case 1:
				System.out.println("_______________________________________________________");
				System.out.println("List of all users");
				empdao.displayEmployeeDetails();
				System.out.println("_______________________________________________________");
				break;
			case 2:
				System.out.println("Select an employee with their user name");
				String name = br.readLine();
				emp.setUSERNAME(name);
				System.out.println("The details of employee: "+name);
				empdao.selectUser(emp);
				break;
			case 3:
				break;
			}
			}while(option!=3);
			break;
		case 3:
			do {
				System.out.println("1.update employee email");
				System.out.println("2.update employee mobile number");
				System.out.println("3.Exit");
				option=Integer.parseInt(br.readLine());
			
			switch(option) {
			case 1:
				System.out.println("Enter the employee id");
				id=Integer.parseInt(br.readLine());
				System.out.println("Enter the email to update");
				String new_email=br.readLine();
				empdao.updateEmail(id,new_email);
				System.out.println("Email updated...");
				System.out.println("_______________________________________________________");
				break;
			case 2:
				System.out.println("Enter the employee id");
				id=Integer.parseInt(br.readLine());
				System.out.println("Enter the mobile number to update");
				long new_number=Long.parseLong(br.readLine());
				empdao.updateMobileNumber(id,new_number);
				System.out.println("Mobile number updated");
				System.out.println("_______________________________________________________");
				break;
			case 3:
				break;
				
			}
			}while (option!=3);
			break;
		case 4:
			System.out.println("Enter the employee id to delete");
			id=Integer.parseInt(br.readLine());
			empdao.deleteEmployee(id);
			System.out.println("Employee "+id+" details deleted...");
			System.out.println("_______________________________________________________");
			break;
		case 5:
			break;
		}
		}while(option!=5);
	}

}


//Statement -> static SQL query
//preparedStatement -> parameterized SQL Query

//Statement -> execute() -> general SQL Statement
//executeUpdate() -> INSERT, UPDATE, DELETE
//executeQuery() -> SELECT
