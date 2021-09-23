package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.DepartmentDao;
import com.dao.DepartmentDaoImplementation;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImplementation;
import com.model.Department;
import com.model.Employee;

public class DepartmentImplementation implements DepartmentService {
	
	DepartmentDao departmentDao;
	 
	 public DepartmentImplementation() {
		 
		 departmentDao = new DepartmentDaoImplementation();
	 }

		public DepartmentImplementation(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
		
	

	


		
	}

