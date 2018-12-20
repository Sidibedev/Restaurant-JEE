package com.lng.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ModelDAO {
	private static Connection connection;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "resto","resto");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	
}
