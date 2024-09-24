package com.mentormind.practo;

public class User {
	private int userId;
	private String username;
	private String email;
	private long phone;
	private String password;

	public User(String username, String email, long phone, String password) {
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
