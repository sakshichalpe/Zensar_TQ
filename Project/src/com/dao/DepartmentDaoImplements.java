package com.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.configuration.ConnectionFactory;
import com.model.Department;
public class DepartmentDaoImplements implements DepartmentDao {
	// ConnectionFactory connectionfactory;
      public DepartmentDaoImplements() {
		//  connectionfactory=new ConnectionFactory();
	}
      
	public int insertDepartment(Department department) {
		System.out.println(department);
		int status=0;
		Connection connection=null;
		PreparedStatement preparedStatment=null;
		try {
			   connection=ConnectionFactory.getConnection();
			   preparedStatment=connection.prepareStatement("insert into department values(?,?,?)");
			   
			    preparedStatment.setString(1, department.getDep_name());
			    preparedStatment.setInt(2,department.getDep_id());
			    status=preparedStatment.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				   if(preparedStatment!=null)
					   preparedStatment.close();
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
	 
}