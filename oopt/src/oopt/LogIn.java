/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

/**
 *
 * @author USER
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//sdfsdsdf
public class LogIn {
    public static final String STAFF_FILE = "src/data1/staff.txt";
    public static final String MEMBER_FILE = "src/data1/member.txt";
    private static final Scanner sc = new Scanner(System.in);

    public static void LogInUser() {
        String userId = null;
        String userPsw;

        boolean valid = true;
        while (valid) {
            System.out.print("Enter user ID: ");
            userId = sc.next();

            // Check if the user ID starts with 'HGL' or 'ADM' and is followed by 5 digits
            if (userId.matches("HGL\\d{5}") || userId.matches("ADM\\d{5}")) {
                valid = false;
            } else {
                System.out.println("Invalid user ID format. Please start with 'HGL' or 'ADM' followed by 5 digits.");
            }
        }

        System.out.print("Enter password: ");
        userPsw = sc.next();

        if (userId.startsWith("HGL")) {
            // Member login
            if (authenticateUser(userId, userPsw, MEMBER_FILE)) {
                System.out.println("Member login successful!");
                // Access member-specific properties like loyalty points if needed
                int loyaltyPoints = getLoyaltyPoints(userId, MEMBER_FILE);
                CusMenu.cusMenu();
                return; 
            }
        } else if (userId.startsWith("ADM")) {
            // Staff login
            if (authenticateUser(userId, userPsw, STAFF_FILE)) {
                System.out.println("Staff login successful!");
                StaffMenu.staffMenu();
                return; 
            }
        } else {
            System.out.println("Invalid user ID format. Please start with 'HGL' or 'ADM'.");
        }

        System.out.println("Invalid user ID or password. Please try again.");
    }

    private static boolean authenticateUser(String userId, String password, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String storedUserId = parts[0];
                    String storedPassword = parts[1];

                    if (userId.equals(storedUserId) && password.equals(storedPassword)) {
                        return true; // Authentication successful
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data from file: " + e.getMessage());
        }
        return false; // Authentication failed
    }

    private static int getLoyaltyPoints(String userId, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String storedUserId = parts[0];
                    int loyaltyPoints = Integer.parseInt(parts[2]);

                    if (userId.equals(storedUserId)) {
                        return loyaltyPoints;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data from file: " + e.getMessage());
        }
        return 0; // Default loyalty points
    }
}