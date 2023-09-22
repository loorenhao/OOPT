/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.util.Random;

/**
 *
 * @author Cyborg
 */
public class Guest extends Customer {
    private String userId; // Randomly generated user ID for guests

    public Guest() {
        super(null, null); // Null values for user ID and password
        generateRandomUserId();
    }

    // Constructor with a specified userId
    public Guest(String userId) {
        super(userId, null); // Specify the userId but keep the password as null
        this.userId = userId;
    }

        // Getter for userId, but no password for guests

    /**
     *
     * @return
     */
    @Override
    public String getUserId() {
        return userId;
    }
    
    private void generateRandomUserId() {
        // Generate a random user ID (you can use any random generation logic)
        var random = new Random();
        userId = "GUEST" + random.nextInt(1000);
    }
    
    
    
}
