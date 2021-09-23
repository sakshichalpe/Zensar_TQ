package com.model;
import java.util.List;

import com.dao.EmployeeDao;

public  class Employee  {
	
private int Emp_id;
private int Emp_salary;
private  String Emp_name;
private  String Email;
private String Emp_mb;
private int dept_id;

public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(int emp_id, int emp_salary2, String emp_name, String email, String emp_mb, int dept_id) {
	super();
	Emp_id = emp_id;
	Emp_salary = emp_salary2;
	Emp_name = emp_name;
	Email = email;
	Emp_mb = emp_mb;
	this.dept_id = dept_id;
}

@Override
public String toString() {
	return "Employee [Emp_id=" + Emp_id + ", Emp_salary=" + Emp_salary + ", Emp_name=" + Emp_name + ", Email=" + Email
			+ ", Emp_mb=" + Emp_mb + ", dept_id=" + dept_id + "]";
}

public int getEmp_id() {
	return Emp_id;
}

public void setEmp_id(int emp_id) {
	Emp_id = emp_id;
}

public int getEmp_salary() {
	return Emp_salary;
}

public void setEmp_salary(int emp_salary) {
	Emp_salary = emp_salary;
}

public String getEmp_name() {
	return Emp_name;
}

public void setEmp_name(String emp_name) {
	Emp_name = emp_name;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getEmp_mb() {
	return Emp_mb;
}

public void setEmp_mb(String emp_mb) {
	Emp_mb = emp_mb;
}

public int getDept_id() {
	return dept_id;
}

public void setDept_id(int dept_id) {
	this.dept_id = dept_id;
}




}




