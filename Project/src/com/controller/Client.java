package com.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.model.Department;
import com.model.Employee;
import com.service.DepartmentService;
import com.service.DepartmentServiceImplements;
import com.service.EmployeeService;
import com.service.EmployeeServiceImplementation;

public class Client {
	static String str;

	public static boolean isValidations(String mobilenumber) {
		Pattern pattern = Pattern.compile(("(0/91)?[7-9][0-9]{9}"));
		Matcher match = pattern.matcher(mobilenumber);
		return (match.find() && match.group().equals(mobilenumber));
	}

	public static boolean isValidationsCharacter(String employeeName) {
		Pattern pattern = Pattern.compile(("[a-zA-Z0-9 ]*"));
		Matcher match = pattern.matcher(employeeName);
		return (match.find() && match.group().equals(employeeName));
	}

	public static boolean isValidationsEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		Matcher match = pattern.matcher(email);
		return (match.find() && match.group().equals(email));

	}

	public static void main(String[] args) {

		DepartmentService departmentservice = new DepartmentServiceImplements();
		EmployeeService employeeservice = new EmployeeServiceImplementation();
		Scanner sc = new Scanner(System.in);
		System.out.println("***************HR Mangement System****************");
		System.out.println("*********Login************");
		System.out.println("Enter Username: ");
		String userName = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		if (userName.equals("Sakshi") && password.equals("Sakshi")) {
			System.out.println("***********Login Successfully done!*******");
			
			System.out.println("*********Welcome********");
			do {

				System.out.println(
						"1.EmployeeDetails\t" + "\n" + "2.Add Employee\t" + "\n" + "3.Update Employee Details" + "\n"
								+ "4.Delete Employee\t" + "\n" + "5.SearchEmployeebyId\t" + "\n" + "6.Add Department"
								+ "\n" + "7.DepartmentNamebyCount" + "\n" + "8.List of Employee from department");

				System.out.println("\nEnter your choice: ");
				int choice = sc.nextInt();

				List<Employee> list = employeeservice.getAllEmployee();
				Iterator<Employee> itr = list.iterator();
				switch (choice) {

				case 1:
					System.out.println("********** All Employee Details *****");
					while (itr.hasNext()) {
						Employee employee = itr.next();
						
						System.out.println("Employee Id:- " + employee.getEmp_id());
						System.out.println("Employee name:- " + employee.getEmp_name());
						System.out.println("Employee Salary:- " + employee.getEmp_salary());
						System.out.println("Employee Mobile no:- " + employee.getEmp_mb());
						System.out.println("Employee Email:- " + employee.getEmail());
						System.out.println("Employee dept Id:- " + employee.getDept_id());
						System.out.println("**************************************");
				
					}
					break;

				case 2:

					System.out.println("");
					System.out.println("********Enter Employee Information******");
					System.out.println("Enter Employeeid: ");
					int Emp_id= sc.nextInt();
					System.out.println("Enter Employeename: ");
					String emp_name = sc.next();
					if (isValidationsCharacter(emp_name)) {

					} else {
						System.out.println("It contain special character which is invalid:");
						System.out.println("Please enter again employeename:  ");
						emp_name = sc.next();
					
					}
					System.out.println("Enter Employee Name:- ");
					String Emp_name = sc.next();
					System.out.println("Enter Employee Salary:- ");
					int emp_salary = sc.nextInt();
					System.out.println("Enter Employee email:- ");
					String Email = sc.next();
					System.out.println("Enter Employee Mobile No:- ");
					String Emp_mb = sc.next();
					System.out.println("Enter Department id:- ");
					int Dept_id = sc.nextInt();
					if (isValidations(Emp_mb)) {

					} else {
						System.out.println("Enter mobile number is invalid");
						System.out.println("Please enter again:  ");
						Emp_mb = sc.next();
					}
					System.out.println("Enter Employee Email:");
					String email = sc.next();
					if (isValidationsEmail(email)) {
						System.out.println();
					} else {
						System.out.println("Enter Email is invalid: ");
						System.out.println("Please enter again:  ");
						email = sc.next();
					}
					
					/*Employee employee = new Employee(int emp_id, String emp_name1, int emp_salary2, String email1, 
							String emp_mb, int Dept_id1				);*/
							Employee employee = new Employee();	
		       int status = employeeservice.insertEmployee(employee);
					if (status > 0) {
						System.out.println("row  added successfully: " + status);
					} else {
						System.out.println("unable to added employee");
					}
					break;

				case 3:

					System.out.println("*********Update Employee Information******");
					System.out.println("Enter EmployeeId to be updated: ");
					int employeeId1 = sc.nextInt();
					System.out.println("Enter EmployeeName to be updated: ");
					String employeeName1 = sc.next();
					if (isValidationsCharacter(employeeName1)) {

					} else {
						System.out.println("It contain special character which is invalid:");
						System.out.println("Please enter again employeename:  ");
						employeeName1 = sc.next();
					}
					System.out.println("Enter EmployeeSalary to be updated: ");
					int employeeSalary1 = sc.nextInt();
					System.out.println("Enter Department id to be updated: ");
					int departmnetId1 = sc.nextInt();
					
					System.out.println("Enter MobileNumber to be updated: ");
					String mobileNumber1 = sc.next();
					if (isValidations(mobileNumber1)) {

					} else {
						System.out.println("*********Enter mobile number is invalid********");
						System.out.println("Please enter again:  ");

						mobileNumber1 = sc.next();
					}
					System.out.println("Enter Email to be updated");
					String email11 = sc.next();
					if (isValidationsEmail(email11)) {

					} else {
						System.out.println("Enter Email is invalid: ");
						System.out.println("Please enter again:  ");
						email11 = sc.next();
					}
					Employee employee1 = new Employee();
					boolean statusupdate = employeeservice.updateEmployee(employee1);
					if (statusupdate) {
						System.out.println("Employee update successfully");
					} else {
						System.out.println("Enable to update employee ");
					}

					break;
				case 4:
					System.out.println("********* Delete Employee Details*********** ");
					System.out.println("Enter Employee id to be Deleted");
					int employeeId2 = sc.nextInt();
					int statusdelete = employeeservice.deleteEmployee(employeeId2);
					if (statusdelete > 0) {
						System.out.println("row deleted successfully: " + statusdelete);
					} else {
						System.out.println("Unable to delete employee details");
					}
					break;
				case 5:
					System.out.println("*************Search by employee id********************");
					System.out.println("Enter employee id");
					int employeeid3 = sc.nextInt();
					Employee employeedetails = employeeservice.searchEmployeebyId(employeeid3);
					if (employeedetails != null) {
						System.out.println("Employee id:  " + employeedetails.getEmp_id());
						System.out.println("Employee id:  " + employeedetails.getEmp_name());
						
						System.out.println("Employee salary: " + employeedetails.getEmp_salary());
		
						System.out.println("Department Id:  " + employeedetails.getDept_id());
						
						System.out.println("Mobile Number: " + employeedetails.getEmp_mb());
						System.out.println("Email : " + employeedetails.getEmail());
					} else {
						System.out.println("Employee record is not available");
					}
					break;
				case 6:
					System.out.println("");
					System.out.println("********Enter Department information**********");
					System.out.println("Enter Department Id");
					
					
					System.out.println("Enter Department Name");
					String departmentName2 = sc.next();
					System.out.println("Enter the Department Locations");
					int departmentId2 = sc.nextInt();
					Department department = new Department( departmentName2,departmentId2 );
					int statusDepartment = departmentservice.insertDepartment(department);
					if (statusDepartment > 0) {
						System.out.println("Department record Added Successfully");
					} else {
						System.out.println("Unable to add department details");
					}
					break;
				case 7:

					System.out.println("**********Strength of Department********");
					System.out.println("***Count according to departmentname***");
					employeeservice.departmentWiseEmployeeCount();
					break;

				case 8:
					System.out.println("List of employee for department by Id");
					System.out.println("Enter Department id: ");
					int employeeid4 = sc.nextInt();
					List<Employee> employeelist = employeeservice.departmentHaveEmployee(employeeid4);
					for (Employee departmentRecord : employeelist) {
						if (departmentRecord != null) {
							
							System.out.println("Employee id:  " + departmentRecord.getEmp_id());
							System.out.println("Employee id:  " + departmentRecord.getEmp_name());
							System.out.println("Employee salary: " + departmentRecord.getEmp_salary());
			
							System.out.println("Department Id:  " + departmentRecord.getDept_id());
							
							System.out.println("Mobile Number: " + departmentRecord.getEmp_mb());
							System.out.println("Email : " + departmentRecord.getEmail());
							
							System.out.println("______________________________________________");
						} else {
							System.out.println("Employee record is not available");
						}
					}
				}

				System.out.println();
				System.out.println("Do you wish to continue(y/n)?");
				str = sc.next();
			} while (str.equals("y") || str.equals("Y"));
		} else {
			System.out.println("Authentication Failed ");
			System.out.println("Wrong Username and Password");
		}

	}
}