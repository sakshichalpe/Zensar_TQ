package com.configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;      //import pkg

public class ConnectionFactory {                                                  

	static final String URL="jdbc:mysql://localhost:3306/hr_management";              //Mysql workbeanch
	static final String USER="root";
	static final String PASS="Root";
	
	public static Connection getConnection() throws SQLException
	{
		Connection connection=null;
		connection=DriverManager.getConnection(URL,USER,PASS);      
		return connection;
	}

	public static void main(String[] args) throws SQLException
	{		
			Connection con = ConnectionFactory.getConnection();
			if(con!=null)
			System.out.println("Connected to MySQL successfully ...");
			else
			System.out.println("Not COnnected to MySQL successfully ...");
	}
}


