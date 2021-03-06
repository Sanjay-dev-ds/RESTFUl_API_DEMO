package com.telusko.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlienDb {

	
	private String jdbcURL = "jdbc:mysql://localhost:3306/restdb";
	private String jdbcUsername =  "root";
	private String jdbcPassword = "";
	
	// get database connection
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}

