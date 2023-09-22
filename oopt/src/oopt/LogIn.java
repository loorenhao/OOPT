/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.util.Scanner;

/**
 *
 * @author USER
 */
class LogIn {

    public static final String STAFF_FILE = "src/data1/staff.txt";
    public static final String MEMBER_FILE = "src/data1/member.txt";
    private static final Scanner sc = new Scanner(System.in);

    public static void LogInStaff() {
        String userId;
        String userPsw;

        boolean vali = true;
        while (vali) {
            System.out.print("Enter user ID: ");
            userId = sc.next();

            // Check if the user ID starts with 'HGL' and is followed by 5 digits
            if (userId.matches("HGL\\d{5}")||userId.matches("ADM\\d{5}")) {
                 vali = false;
            }
            else{
                System.out.println("Invalid user ID format. Please start with 'HGL' or 'ADM' followed by 5 digits.");
            }
        }
        
        
    }
        //            System.out.print("Enter password: ");
        //            userPsw = sc.next();
        //
        //            if (userId.startsWith("HGL")) {
        //                // Member login
        //                Member member = (Member) readUserFromFile(MEMBER_FILE);
        //                if (member != null && member.authenticate(userId, userPsw)) {
        //                    System.out.println("Member login successful!");
        //                    // Access member-specific properties like loyalty points if needed
        //                    int loyaltyPoints = member.getLoyaltyPoints();
        //                    // Proceed with member-specific logic
        //                    customerMenu();
        //                    return; // Exit the loginMenu() and return to the main menu
        //                }
        //            } else if (userId.startsWith("ADM")) {
        //                // Staff login
        //                Staff staff = (Staff) readUserFromFile(STAFF_FILE);
        //                if (staff != null && staff.authenticate(userId, userPsw)) {
        //                    System.out.println("Staff login successful!");
        //                    staffMenu(); // Enter staff-specific logic
        //                    return; // Exit the loginMenu() and return to the main menu
        //                }
        //            } else {
        //                System.out.println("Invalid user ID format. Please start with 'HGL' or 'ADM'.");
        //            }
        //
        //            System.out.println("Invalid user ID or password. Please try again.");
        //        } while (true);
        //    }
        //
        //    private static User readUserFromFile(String fileName) {
        //        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName))) {
        //            String line;
        //            if ((line = reader.readLine()) != null) {
        //                String[] parts = line.split(",");
        //                if (parts.length >= 2) {
        //                    String userId = parts[0];
        //                    String userPsw = parts[1];
        //
        //                    // Check if it's a member or staff based on the prefix in the userId
        //                    if (userId.startsWith("HGL")) {
        //                        // Member
        //                        return new Member(userId, userPsw);
        //                    } else if (userId.startsWith("ADM")) {
        //                        // Staff
        //                        Staff staff = new Staff(userId, userPsw);
        //                        if (parts.length >= 3) {
        //                            String position = parts[2];
        //                            staff.setPosition(position);
        //                        }
        //                        return staff;
        //                    }
        //                }
        //            }
        //        } catch (IOException e) {
        //            System.err.println("Error reading user data from file: " + e.getMessage());
        //        }
        //        return null; // Return null if user data couldn't be read or is invalid
        //
        //    
        //
    




}
