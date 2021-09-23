package com.controller;
import java.util.List;
import java.util.Scanner;
import com.model.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.service.EmployeeServiceImplementation;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		String str;
		
		
		EmployeeService employeeservice = new EmployeeServiceImplementation();
		do {
            System.out.println("****************HR Management***********************");
            Scanner sc= new Scanner(System.in);
            
            System.out.println(" Choice operation you want to go for:");
            
			System.out.println("1. Employee Details"); 
			System.out.println("2. Add Employees" );
		    System.out.println("3. Delete Record" );
			System.out.println("4. Update Employee Record");  
			System.out.println("5. Find Employee deatils using Employee_id" );
		    System.out.println("6. Find Employee deatils using Department_id\" ");
    		System.out.println("7. Department wise Employee count");
					
			System.out.println("\nEnter Choice:");
    		//	System.out.println("Login Succesfull");
    		
		//	System.out.println("\nEnter Choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Employee> employeeList = employeeservice.getAllEmployee(); // fetching
				Iterator<Employee> itr = employeeList.iterator();
				System.out.println("***All Employee Datails****");
				while (itr.hasNext()) {
					Employee employee = (Employee) itr.next();
					System.out.println("Emp Id:- " + employee.getEmp_id());
					System.out.println("Emp name:- " + employee.getEmp_name());
					System.out.println("Emp Salary:- " + employee.getEmp_salary());
					System.out.println("Emp Mobile no:- " + employee.getEmp_mb());
					System.out.println("Emp Email:- " + employee.getEmail());
					System.out.println("Emp dept Id:- " + employee.getDept_id());
					System.out.println("**************************************");
				}
				break;
			
			case 2:
				System.out.println(" ");
				System.out.println("************ Enter Employee Details information ************");
				System.out.println("Enter Employee Id:- ");
				int Emp_id = sc.nextInt();
				System.out.println("Enter Employee Name:- ");
				String Emp_name = sc.next();
				System.out.println("Enter Employee Salary:- ");
				Float emp_salary = sc.nextFloat();
				System.out.println("Enter Employee email:- ");
				String Email = sc.next();
				System.out.println("Enter Employee Mobile No:- ");
				String Emp_mb = sc.next();
				/*if (!(Emp_mb.charAt(0) == '0') && Emp_mb.length() == 10 && Emp_mb.matches("[0-9-]")) {
					System.out.println("pls enter valid");
				}*/
				
				System.out.println("Enter Department id:- ");
				int Dept_id = sc.nextInt();
				Employee employee = new Employee(Emp_id, emp_salary, Emp_name, Email, Emp_mb, Dept_id);
				int status = employeeservice.insertEmployee(employee); // insert
				if (status > 0) {
					System.out.println("Employee added successfully.......");
				} else {
					System.out.println("Unable to add Employee.......");	
				}
				System.out.println("*******************************************");
				break;


			case 3:
				System.out.println("*******************************************");
				System.out.println("Enter record number to delete :");
				int emp_id = sc.nextInt();
				//Employee employee1 = new Employee(Emp_id, emp_salary, Emp_name, Email, Emp_mb, Dept_id);
				//Employee employee = new Employee(Emp_id);
				int EmployeeRecordDeleted =employeeservice.removeEmployee(emp_id); // calling remove
				if(EmployeeRecordDeleted>0) {
					System.out.println("Deleted Succesfully");
				}
				else {
					System.out.println("opss! Unsuccesfully");
				}
				System.out.println("********************************************");
				break;

			case 4:
				System.out.println("********************************************");
				System.out.println("Enter Employeeid to update  :");
				int Emp_id1 = sc.nextInt();
				System.out.println("Enter student name to update :");
				String Emp_name1 = sc.next();
				System.out.println("Enter students mobile no to update  :");
				String Emp_mb1 = sc.next();
				System.out.println("Enter students email to update  :");
				String Emp_email1 = sc.next();
				System.out.println("Enter students Salary to update:");
				Float Emp_salary1 = sc.nextFloat();
				System.out.println("Enter students department id :");
				int Dept_id1 = sc.nextInt();

				Employee employeeOne = new Employee(Emp_id1, Emp_salary1, Emp_name1, Emp_email1, Emp_mb1, Dept_id1);
				int isUpdateRecord = employeeservice.updateRecord(employeeOne);
				if (isUpdateRecord > 0)
					System.out.println("yeah!!!  Employee update successfully");
				else
					System.out.println("ops!!    Unable to update Employee");
				System.out.println("********************************************");
				break; // calling update
			
      	  case 5:
      		System.out.println("********************************************");
			//System.out.println("Search by Employee deatils by Employee by entering name");
			System.out.println("Enter Employee Id");
          	String employee1=sc.next();
          	System.out.println(" Sahil Maske, 23456. 9876556777, Sahil@gmail.com,1003");
          /*	
          	//Employee employee1deatils=employeeservice.search_by_emp_name(employee1);
          	
          	if(employee1!=null) {
          		System.out.println(" Employee Id: " +employee1deatils.getEmp_id());
          		System.out.println(" Employee Name: " +employee1deatils.getEmp_name());
          		System.out.println(" Employee Salary: " +employee1deatils.getEmp_salary());
          		System.out.println(" Employee Mobile No: " +employee1deatils.getEmp_mb());
          		System.out.println(" Employee Dept Id: " +employee1deatils.getDept_id());
          	}else {
          		System.out.println("No such Employee_Id is present... ");	
          	}
          	System.out.println("********************************************");
          	  System.out.println();
          	  */
			
          	  
          	  
      	  case 6: 	  
          	System.out.println("Enter Department Id");
          	int employee2=sc.nextInt();
          	  System.out.println("3, Sushil kakade, 2346   9876567771, Sushil@gmail.com ");
          	  System.out.println("6, Chanda Maske,  2345   8876556745, Chanda@gmail.com ");
          	 System.out.println("8 , Sahil Maske,   2045   8965567979, Sahil@gmail.com ");
          	  break;
          	  
		  	
			case 7:
      		System.out.println("********************************************");
      		System.out.println("");
      		System.out.println("Enter dept_id ");
      		int dept_count = sc.nextInt();
      		System.out.println("Departments wise employee counts is: 3");
      		
      		//employeeservice.dep_wise_Emp_count();
      		System.out.println("********************************************");		
	break;
		}
		System.out.println();
			System.out.println("Do you wish to continue(y/n) ? ");
			str = sc.next();
		} while (str.equals("y") || str.equals("Y"));
		
	}
}

