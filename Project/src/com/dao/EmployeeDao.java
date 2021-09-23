package com.dao;
import java.util.List;
import java.util.ArrayList;
import com.model.Employee;
public interface EmployeeDao 
{
	            //fetch data by emp_id
		List<Employee> getAllEmployee();                            //display data
		
		int insertEmployees(Employee employee);                    //insert
		
		int removeEmployee(int emp_id);                             //delete 
		
		int updateRecord(Employee employeeOne);                       //update
		
		void dep_wise_Emp_count(); 
	
		
		Employee search_by_emp_name(String name);                  //display by emp_id
		
		//Employee search_by_dept_id(Employee employeeThree);           //fetch data by dep_id
		
		// List <Employee> search_by_dept_id(int dept_id);           //display by dep_id

	//	Employee search_by_dept_id(int employeeid);
			
		}



		
		 
	
	 
	 

