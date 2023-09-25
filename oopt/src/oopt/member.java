/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

/**
 *
 * @author USER
 */

public class Member extends Customer {
    private int loyaltyPoints;

    public Member(String userId, String userPsw) {
        super(userId, userPsw);
        loyaltyPoints = 0;
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

}
