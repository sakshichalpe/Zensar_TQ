package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.configuration.ConnectionFactory;
import com.model.Employee;
//import com.sun.source.tree.CatchTree;

public class EmployeeDaoImplementation implements EmployeeDao {
	// ConnectionFactory connectionfactory;

	public EmployeeDaoImplementation() {
		// connectionfactory = new ConnectionFactory();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String Query = "select * from employee";
		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(Query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				
				employee.setEmp_id(resultSet.getInt("emp_id"));
				employee.setEmp_name(resultSet.getString("emp_name"));
				employee.setEmail(resultSet.getString("emp_email"));	
			    employee.setEmp_mb(resultSet.getString("emp_mb"));
			    employee.setDept_id(resultSet.getInt("dept_id"));
			    employee.setEmp_salary(resultSet.getInt("emp_salary"));
				employeeList.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	public int deleteEmployee(int id) {
		int statusdelete = 0;
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement("Delete from employee where emp_id=?");
			preparedStatment.setInt(1, id);
			statusdelete = preparedStatment.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusdelete;

	}

	@Override
	public int insertEmployee(Employee employee) {
		System.out.println(employee);
		int status = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,employee.getEmp_id());
			preparedStatement.setString(2, employee.getEmp_name());
			preparedStatement.setFloat(3, employee.getEmp_salary());
			preparedStatement.setString(4,employee.getEmail());
			preparedStatement.setString(5, employee.getEmp_mb());
			preparedStatement.setInt(6,employee.getDept_id());
			
			
			status = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		try {
			
			int i = preparedStatment.executeUpdate();
			if (i == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatment != null)
					preparedStatment.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public Employee searchEmployeebyId(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Employee employee = null;
		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("Select * from employee where EmployeeId=?");
			preparedStatement.setInt(1, id);
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				employee = new Employee();
				
				employee.setEmp_name(resultset.getString("Emp_name"));
				employee.setEmp_mb(resultset.getString("Emp_mb"));
				employee.setEmail(resultset.getString("Email"));
				employee.setEmp_salary(resultset.getInt("Emp_salary"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return employee;
	}

	@Override
	public void departmentWiseEmployeeCount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select d.department,count(e.emp_id) from department d join employee e on d.departmentid=e.depart group by d.deptname";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(
						"DepartmentName:" + resultSet.getString(1) + " Count of Employee: " + resultSet.getInt(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> departmentHaveEmployee(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		ArrayList<Employee> list = new ArrayList<>();
		Employee employee = null;
		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("Select * from employee where Dept_id=?");
			preparedStatement.setInt(1, id);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				employee = new Employee();
				
//int emp_id, int emp_salary2, String emp_name, String email, String emp_mb, int dept_id) {	
				employee.setEmp_id(resultset.getInt("emp_id"));
				employee.setEmp_salary(resultset.getInt("emp_salary"));
				employee.setEmp_name(resultset.getString("emp.name"));
				employee.setEmail(resultset.getString("email"));
				employee.setEmp_mb(resultset.getString("emp_mb"));
				employee.setDept_id(resultset.getInt("dept_id"));
				
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				// TODO: handle exception
			}

		}
		return list;
	}

}