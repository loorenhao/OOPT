/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.*;
import java.util.*;

/**
 *
 * @author USER
 */
public class Staff extends User {

    private static final String STAFF_FILE = "src/data1/staff.txt";
    private String Position;
    
    public Staff (String userId, String password){
        super(userId, password);
    }

    public Staff(String Position, String userId, String password) {
        super(userId, password);
        this.Position = Position;
    }

    public String getPosition() {
        return Position;
    }

    @Override
    public String toDataString() {
        return getUserId() + "," + getUserPsw() + "," + getPosition();
    }

    public static void displayStaffDetails() {
        List<String> staffData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(STAFF_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                staffData.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading member data from file: " + e.getMessage());
            return;
        }

        if (staffData.isEmpty()) {
            System.out.println("No member records found.");
            return;
        }

        System.out.println("No.\tUser ID\t\tPosition");

        int counter = 1;
        for (String staffInfo : staffData) {
            String[] parts = staffInfo.split(",");
            String userId = parts[0];
            String position = parts[2];

            System.out.println(counter + ".\t" + userId + "\t\t" + position);
            counter++;
        }
    }

    public static void displayStaffLogin(String userId, String password) {
        List<String> staffData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(STAFF_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                staffData.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading member data from file: " + e.getMessage());
            return;
        }

        if (staffData.isEmpty()) {
            System.out.println("No member records found.");
            return;
        }

        boolean found = false;

        for (String staffInfo : staffData) {
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
