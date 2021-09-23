package com.service;

import com.dao.DepartmentDao;
import com.dao.DepartmentDaoImplements;
import com.model.Department;

public class DepartmentServiceImplements implements DepartmentService{

      DepartmentDao departmentdao;
      
     public DepartmentServiceImplements() {
		 departmentdao=new DepartmentDaoImplements();
	}
     
	public int insertDepartment(Department department) {
		
		return departmentdao.insertDepartment(department);
	}

}