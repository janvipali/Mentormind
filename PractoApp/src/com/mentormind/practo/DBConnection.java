package com.mentormind.practo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public class DatabaseConnection {
		private static final String URL = "jdbc:mysql://localhost:3306/PractoByShubhamPustake7699";
		private static final String USER = "root";
		private static final String PASSWORD = "root";

		public static Connection getConnection() {
			Connection connection = null;
			try {
				connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}