package com.mentormind.practo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mentormind.practo.DBConnection.DatabaseConnection;

public class AppointmentService {
	public void bookAppointment(Appointment appointment) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "INSERT INTO appoiments (patient_name, patient_phone, patient_age, patient_gender, blood_grp, appoiment_date, appoimentTime, address, patient_email, doctor_name, doctor_contact, UserID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, appointment.getPatientName());
			ps.setLong(2, appointment.getPatientPhone());
			ps.setInt(3, appointment.getPatientAge());
			ps.setString(4, appointment.getPatientGender());
			ps.setString(5, appointment.getBloodGroup());
			ps.setString(6, appointment.getAppointmentDate());
			ps.setString(7, appointment.getAppointmentTime());
			ps.setString(8, appointment.getAddress());
			ps.setString(9, appointment.getPatientEmail());
			ps.setString(10, appointment.getDoctorName());
			ps.setString(11, appointment.getDoctorContact());
			ps.setInt(12, appointment.getUserId());
			ps.executeUpdate();
			System.out.println("Appointment booked successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addTestDetails(TestDetails testDetails) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "INSERT INTO testDetails (test_name, test_date, price, appointmentId) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, testDetails.getTestName());
			ps.setString(2, testDetails.getTestDate());
			ps.setDouble(3, testDetails.getPrice());
			ps.setInt(4, testDetails.getAppointmentId());
			ps.executeUpdate();
			System.out.println("Test details added successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
