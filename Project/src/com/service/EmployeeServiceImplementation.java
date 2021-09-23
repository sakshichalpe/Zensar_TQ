package com.service;
import java.util.List;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImplementation;
import com.model.Employee;

public class EmployeeServiceImplementation implements EmployeeService  //, EmployeeDao 
{
 EmployeeDao employeeDao;
 
 public EmployeeServiceImplementation() {
	 
	 employeeDao = new EmployeeDaoImplementation();
 }

	public EmployeeServiceImplementation(EmployeeDao employeeDao) {
	this.employeeDao = employeeDao;
}
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public int insertEmployee(Employee employee) {
		
		return employeeDao.insertEmployees(employee);
	}
	@Override
	public int removeEmployee(int emp_id) {
	
		return employeeDao.removeEmployee(emp_id);
	}
	
	public int updateRecord(Employee employeeOne) {
		return employeeDao.updateRecord(employeeOne);
	}

	
	/* 
    public List<Employee> search_by_dept_id(int departmentid) {
		
		return employeeDao.search_by_dept_id(employee2);
	}*/

	@Override
	public Employee search_by_emp_name(String name) {
		
		return employeeDao.search_by_emp_name(name);
	}

	@Override
	public void dep_wise_Emp_count() {
		employeeDao.dep_wise_Emp_count();
		
	} 
	

		
	}



