package com.service;
	import java.util.List;

	import java.util.ArrayList;
	import com.model.Employee;
	public interface EmployeeService {

			List<Employee> getAllEmployee();
			
			int insertEmployee(Employee employee);
			int removeEmployee(int emp_id);
			int updateRecord(Employee employeeOne);
			
			Employee search_by_emp_name(String name);    
           // Employee search_by_emp_id(Employee employeeTwo);
            void dep_wise_Emp_count(); 
        
           // public List<Employee> search_by_dept_id(int departmentid);
			

			
            //  void search_emp_details_dept_          //1)API
	}
	
			
			

			
			 

