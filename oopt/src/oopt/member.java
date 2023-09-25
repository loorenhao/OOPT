
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
public class Member extends Customer {

    public static final String MEMBER_FILE = "src/data1/member.txt";

    private int loyaltyPoints;

    public Member(String userId, String userPsw, int loyaltyPoints) {
        super(userId, userPsw);
        this.loyaltyPoints = loyaltyPoints;
    }

    // Additional methods or properties specific to Member users
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    @Override
    public String toDataString() {
        return getUserId() + "," + getUserPsw() + "," + getLoyaltyPoints();
    }

    public static void displayMemberDetails() {
        List<String> memberData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                memberData.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading member data from file: " + e.getMessage());
            return;
        }

        if (memberData.isEmpty()) {
            System.out.println("No member records found.");
            return;
        }

        System.out.println("No.\tUser ID\t\tLoyalty Points");

        int counter = 1;
        for (String memberInfo : memberData) {
            String[] parts = memberInfo.split(",");
            String userId = parts[0];
            int loyaltyPoints = Integer.parseInt(parts[2]);

            System.out.println(counter + ".\t" + userId + "\t\t" + loyaltyPoints);
            counter++;
        }
    }

}
