package com.intellimed.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		Connection connection = null;
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
