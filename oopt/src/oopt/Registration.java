/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.*;
import java.util.*;

/**
 *
 * @author Cyborg
 */
public class Registration {

    private static final String filePath = "src/data1/";
    private static final String STAFF_FILE = "src/data1/staff.txt";
    private static final String MEMBER_FILE = "src/data1/member.txt";

    private static final Scanner sc = new Scanner(System.in);



    public static void registerStaff() {
        // Implement staff registration logic here
        // Prompt the user for staff ID, password, and job position
        String userId = null;
        String userPsw = null;
        String jobPosition = null;

        boolean valid = true;
        while (valid) {
            System.out.print("\nEnter staff user ID (must start with 'ADM' followed by 5 digits): ");
            userId = sc.next();

            // Check if the user ID starts with 'ADM' and is followed by 5 digits
            if (!userId.matches("ADM\\d{5}")) {
                System.out.println("Invalid user ID format. Please start with 'ADM' followed by 5 digits.");
                continue; // Repeat the loop if the user ID format is invalid
            }

            // Check if the user already exists in the staff.txt file
            if (isUserExists(userId, STAFF_FILE)) {
                System.out.println("User with the same ID already exists. Please choose a different ID.\n");
                continue; // Repeat the loop if the user ID already exists
            }

            valid = false;
        }

        do {
            System.out.print("Enter staff password (password must have exactly 10 characters): ");
            userPsw = sc.next(); // Use sc.nextLine() to read the entire line

            // Check if the password is exactly 10 characters long and contains only digits
            if (userPsw.length() != 10) {
                System.out.println("Password must be exactly 10 characters long.");
            }
        } while (userPsw.length() != 10);

        // Present a menu for job position selection
        System.out.println("Select a job position:");
        System.out.println("1. Cashier");
        System.out.println("2. Inventory Manager");
        System.out.println("3. Customer Service Representative");
        System.out.println("4. Store Manager");

        int choice = 0;
        while (true) {
            System.out.print("Enter your choice (1/2/3/4): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1/2/3/4).");
                sc.next(); // Consume the invalid input
            }
        }

        // Map the user's choice to a job position
        switch (choice) {
            case 1:
                jobPosition = "Cashier";
                break;
            case 2:
                jobPosition = "Inventory Manager";
                break;
            case 3:
                jobPosition = "Customer Service Representative";
                break;
            case 4:
                jobPosition = "Store Manager";
                break;
        }
        // Registration successful
        // Store user data, including job position, in staff.txt
        writeStaffToFile(userId, userPsw, jobPosition, STAFF_FILE);
        System.out.println("Staff registration successful!");
        // Exit the method after successful registration
        FIrstMenu.menu1();

    }

    private static void writeStaffToFile(String userId, String password, String jobPosition, String fileName) {
        // Implement writing staff data to file here
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userId + "," + password + "," + jobPosition + "\n");
        } catch (IOException e) {
            System.err.println("Error writing staff data: " + e.getMessage());
        }
    }

    public static void registerMember() {
        // Implement member registration logic here
        // Prompt the user for member ID and password
        String userId = null;
        String userPsw = null;

        boolean vali = true;
        while (vali) {
            System.out.print("Enter member user ID (must start with 'HGL' followed by 5 digits): ");
            userId = sc.next();

            // Check if the user ID starts with 'HGL' and is followed by 5 digits
            if (!userId.matches("HGL\\d{5}")) {
                System.out.println("Invalid user ID format. Please start with 'HGL' followed by 5 digits.");
                continue; // Repeat the loop if the user ID format is invalid
            }

            // Check if the user already exists in the member.txt file
            if (isUserExists(userId, MEMBER_FILE)) {
                System.out.println("User with the same ID already exists. Please choose a different ID.");
                continue; // Repeat the loop if the user ID already exists
            }

            vali = false;
        }

        do {
            System.out.print("Enter member password (password must have exactly 10 characters): ");
            userPsw = sc.next(); // Use sc.nextLine() to read the entire line

            // Check if the password is exactly 10 characters long and contains only digits
            if (userPsw.length() != 10) {
                System.out.println("Password must be exactly 10 characters long.");
            }
        } while (userPsw.length() != 10);
        // Registration successful
        // Automatically declare loyalty points as 0

        // Pass loyalty points to the writeMemberToFile method
        writeMemberToFile(userId, userPsw, 0, MEMBER_FILE);
        System.out.println("Member registration successful!");

    }

    private static void writeMemberToFile(String userId, String password, int loyaltyPoints, String fileName) {
        // Implement writing member data to file here
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userId + "," + password + "," + loyaltyPoints + "\n");
        } catch (IOException e) {
            System.err.println("Error writing member data: " + e.getMessage());
        }
    }

    private static boolean isUserExists(String userId, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts (user ID and other data)
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(userId)) {
                    return true; // User with the same ID already exists
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data: " + e.getMessage());
        }
        return false; // User does not exist
    }
}