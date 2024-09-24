package com.mentormind.practo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AppointmentService appointmentService = new AppointmentService();
		Scanner scanner = new Scanner(System.in);
		UserService userService = new UserService();

		while (true) {
			System.out.println("Welcome to Practo Appointment System");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				// Registration process
				System.out.println("Register New User");
				System.out.print("Enter Username: ");
				String username = scanner.nextLine();
				System.out.print("Enter Email: ");
				String email = scanner.nextLine();
				System.out.print("Enter Phone No: ");
				long phone = scanner.nextLong();
				System.out.print("Enter Password: ");
				scanner.nextLine();
				String password = scanner.nextLine();

				User newUser = new User(username, email, phone, password);
				userService.registerUser(newUser);
				break;

			case 2:
				// Login process
				System.out.println("Login User");
				System.out.print("Enter Email: ");
				String loginEmail = scanner.nextLine();
				System.out.print("Enter Password: ");
				String loginPassword = scanner.nextLine();

//				boolean isLoggedIn = userService.loginUser(loginEmail, loginPassword);
//				if (isLoggedIn) {
				int isLoggedIn = userService.loginUser(loginEmail, loginPassword);
				if (isLoggedIn > 0) {
					System.out.println("Login successful! You can now book appointments.");
					System.out.println();
					System.out.println("Enter Patient Name:");
					String patientName = scanner.nextLine();
					System.out.println("Enter Patient Phone:");
					long patientPhone = scanner.nextLong();
					System.out.println("Enter Patient Age:");
					int patientAge = scanner.nextInt();
					scanner.nextLine(); // consume newline
					System.out.println("Enter Patient Gender:");
					String patientGender = scanner.nextLine();
					System.out.println("Enter Blood Group:");
					String bloodGroup = scanner.nextLine();
					System.out.println("Enter Appointment Date (YYYY-MM-DD):");
					String appointmentDate = scanner.nextLine();
					System.out.println("Enter Appointment Time (HH:MM:SS):");
					String appointmentTime = scanner.nextLine();
					System.out.println("Enter Address:");
					String address = scanner.nextLine();
					System.out.println("Enter Patient Email:");
					String patientEmail = scanner.nextLine();
					System.out.println("Enter Doctor Name:");
					String doctorName = scanner.nextLine();
					System.out.println("Enter Doctor Contact:");
					String doctorContact = scanner.nextLine();

					Appointment appointment = new Appointment();
					appointment.setPatientName(patientName);
					appointment.setPatientPhone(patientPhone);
					appointment.setPatientAge(patientAge);
					appointment.setPatientGender(patientGender);
					appointment.setBloodGroup(bloodGroup);
					appointment.setAppointmentDate(appointmentDate);
					appointment.setAppointmentTime(appointmentTime);
					appointment.setAddress(address);
					appointment.setPatientEmail(patientEmail);
					appointment.setDoctorName(doctorName);
					appointment.setDoctorContact(doctorContact);
					appointment.setUserId(isLoggedIn);

					appointmentService.bookAppointment(appointment);
					System.out.println();
				}
				break;

			case 3:
				System.out.println("Exiting system...");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}
	}
}