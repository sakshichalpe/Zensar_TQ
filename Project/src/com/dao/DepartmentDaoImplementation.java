package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import com.configuration.ConnectionFactory;
import com.model.Employee;
import com.model.Department;
import java.awt.List;
//import java.util.List;
import java.sql.Connection;

public class DepartmentDaoImplementation<Department> implements DepartmentDao {

	ConnectionFactory ConnectionFactory;
	
		public DepartmentDaoImplementation() 
		{    
			ConnectionFactory = new ConnectionFactory();
		}

		

}
		