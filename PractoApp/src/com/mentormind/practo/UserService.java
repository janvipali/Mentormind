package com.mentormind.practo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mentormind.practo.DBConnection.DatabaseConnection;

public class UserService {

	// Method to register a new user
	public void registerUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "INSERT INTO user (user_name, email_id, phone_no, user_password) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setLong(3, user.getPhone());
			ps.setString(4, user.getPassword());
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("User registered successfully!");
			}
		} catch (SQLException e) {
			System.out.println("Error during registration: " + e.getMessage());
		}
	}

	// Method to login a user
	public int loginUser(String email, String password) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM user WHERE email_id = ? AND user_password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Login successful! Welcome, " + rs.getString("user_name") + ".");
//				return true;
				return rs.getInt("user_id");
			} else {
				System.out.println("Invalid email or password.");
//				return false;
				return -1;
			}
		} catch (SQLException e) {
			System.out.println("Error during login: " + e.getMessage());
		}
//		return false;
		return -1;
	}
}
