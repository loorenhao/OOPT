/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Customer extends User {
    
    private static final String STAFF_FILE = "src/data1/staff.txt";
    private static final String MEMBER_FILE = "src/data1/member.txt";
    
    public Customer(String userId, String userPsw) {
        super(userId, userPsw);
    }
    
    public static void displayCustLogin(String userId, String password) {
        List<String> customerData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                customerData.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading member data from file: " + e.getMessage());
            return;
        }

        if (customerData.isEmpty()) {
            System.out.println("No member records found.");
            return;
        }

        boolean found = false;

        for (String staffInfo : customerData) {
            String[] parts = staffInfo.split(",");
            String storedUserId = parts[0];
            String storedPassword = parts[1];

            if (userId.equals(storedUserId) && password.equals(storedPassword)) {
                String position = parts[2];
                System.out.println("Login successful!");
                System.out.println("User ID: " + userId);
                System.out.println("Position: " + position);
                found = true;
                break; // Stop searching once a match is found
            }
        }

        if (!found) {
            System.out.println("Login failed. User ID or password is incorrect.");
        }
    }
    
    
}

