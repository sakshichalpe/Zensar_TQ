package com.dao;
import java.util.List;
import com.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.configuration.ConnectionFactory;
import com.model.Employee;
public class EmployeeDaoImplementation implements EmployeeDao //throws SQLException 
{
	ConnectionFactory ConnectionFactory;
	
	//**********display************//
	public EmployeeDaoImplementation() 
	{
	 ConnectionFactory = new ConnectionFactory();
	}
	@Override
	public List<Employee> getAllEmployee() {                                //Display
	ArrayList<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String QUERY = "select * from employee";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee= new Employee();
				
				employee.setEmp_id(resultSet.getInt("emp_id"));
				employee.setEmp_name(resultSet.getString("emp_name"));
				employee.setEmail(resultSet.getString("emp_email"));	
			    employee.setEmp_mb(resultSet.getString("emp_mb"));
			    employee.setDept_id(resultSet.getInt("dept_id"));
			    employee.setEmp_salary(resultSet.getFloat("emp_salary"));	 
			    employeeList.add(employee);
			}

		} catch (Exception e) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return employeeList;
	}
	///************insert**************
	public int insertEmployees(Employee employee) {                                        //insert
		System.out.println(employee);
		int status = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setInt(1,employee.getEmp_id());
			preparedStatement.setString(2, employee.getEmp_name());
			preparedStatement.setFloat(3, employee.getEmp_salary());
			preparedStatement.setString(4,employee.getEmail());
			preparedStatement.setString(5, employee.getEmp_mb());
			preparedStatement.setInt(6,employee.getDept_id());
			status=preparedStatement.executeUpdate();
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
				try {
					if(preparedStatement!=null)
					preparedStatement.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
				return status;
	}
	@Override
	///***********remove(delete)******
	public int removeEmployee(int emp_id) {  
		Connection connection=null;
		PreparedStatement preparedStatement =null;//remove
		ResultSet resultSet = null;
		int r=0;
		try {
		connection = ConnectionFactory.getConnection();
		preparedStatement=connection.prepareStatement("delete from employee where Emp_Id=?");
		preparedStatement.setInt(1, emp_id);
		r=preparedStatement.executeUpdate();
		System.out.println("Number of rows deleted : "+r);
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
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
return r;
		
	}
//************Update***********
	@Override //update
	public int updateRecord(Employee employee) 
	{
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		int updateRecord=0;
		try
		{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement("update Employee set Emp_name=?,Emp_mb=?,Emp_email=?,Emp_salary=?,Dept_id=? where Emp_id=?");
			preparedStatement.setString(1, employee.getEmp_name());
			preparedStatement.setString(2,  employee.getEmp_mb());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setFloat(4,employee.getEmp_salary() );
			preparedStatement.setInt(5,employee.getDept_id() );
			preparedStatement.setInt(6, employee.getEmp_id());
			updateRecord=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			
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
		return updateRecord ;
	}
	
	@Override
	public Employee search_by_emp_name(String name) {
		{	
			Connection connection=null;
			PreparedStatement preparedStatement =null;
			ResultSet resultSet=null; 
			Employee employee1=null;
				 try
					{
					 String  Query ="select * from employee where emp_name=?";
						connection = ConnectionFactory.getConnection();
						preparedStatement = connection.prepareStatement(Query);
						resultSet=preparedStatement.executeQuery();
						while(resultSet.next()) {
							employee1 =new  Employee();				
							//employee1.setEmp_name(resultSet.getString("Emp_name"));
							employee1.setEmp_mb(resultSet.getString("Emp_mb"));
							employee1.setEmail(resultSet.getString("Email"));
							employee1.setEmp_salary(resultSet.getFloat("Emp_salary"));
							employee1.setEmp_id(resultSet.getInt("Emp_id"));
					        employee1.setDept_id(resultSet.getInt("Dept_idS"));	
						}	
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					finally {
						
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
				 return employee1;
		
		}
	}
	/*@Override
	public Employee search_by_dept_id(int employeeid) {
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet=null;
		Employee employee2=null;
	    ArrayList<Employee> employeelist1=null;
		   	 try
				{
				 String  Query ="select * from employee where dept_id=?";
					connection = ConnectionFactory.getConnection();
					preparedStatement = connection.prepareStatement(Query);
					resultSet=preparedStatement.executeQuery();
					employeelist1=new ArrayList<>();
					while(resultSet.next()) {
						employee2=new Employee();					
						employee2.setEmp_name(resultSet.getString("Emp_name"));
						employee2.setEmp_mb(resultSet.getString("Emp_mb"));
						employee2.setEmail(resultSet.getString("Email"));
						employee2.setEmp_salary(resultSet.getFloat("Emp_salary"));
						//employee2.setEmp_id(resultSet.getInt("Emp_id"));
						employee2.setDept_id(resultSet.getInt("Dept_id"));
						employeelist1.add(employee2);	
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				finally {
					
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
		   	 return employee2;
		   	// return employeelist1;
	}
*/
	
	public void dept_wise_Emp_count() {
		//ArrayList<Department> departmentList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		 String  Query ="select d.department,count(e.emp_id) from department d join employee e on d.departmentid=e.depart group by d.deptname";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(Query);
			resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getInt(2));
            }
			} catch (Exception e) {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				return ;	
	}
	@Override
	public void dep_wise_Emp_count() {
		// TODO Auto-generated method stub
		
	}

	}

	
