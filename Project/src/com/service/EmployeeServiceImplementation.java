package com.service;

import java.util.List;
import java.util.Set;
import com.configuration.ConnectionFactory;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImplementation;
import com.model.Employee;

public class EmployeeServiceImplementation implements EmployeeService {

	EmployeeDao employeedao;

	public EmployeeServiceImplementation() {
		employeedao = new EmployeeDaoImplementation();

	}

	public List<Employee> getAllEmployee() {

		return employeedao.getAllEmployee();
	}

	@Override
	public int insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.insertEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeedao.updateEmployee(employee);

	}

	@Override
	public int deleteEmployee(int id) {
		return employeedao.deleteEmployee(id);

	}

	@Override
	public Employee searchEmployeebyId(int id) {

		return employeedao.searchEmployeebyId(id);
	}

	@Override
	public void departmentWiseEmployeeCount() {
		employeedao.departmentWiseEmployeeCount();

	}

	@Override
	public List<Employee> departmentHaveEmployee(int id) {
		// TODO Auto-generated method stub
		return employeedao.departmentHaveEmployee(id);
	}

}