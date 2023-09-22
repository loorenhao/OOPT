/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

/**
 *
 * @author USER
 */
public class User {
    private final String userId;
    private final String userPsw;

    public String getUserId() {
        return userId;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.userPsw = password;
    }

    public boolean authenticate(String enteredUserId, String enteredPassword) {
        return userId.equals(enteredUserId) && userPsw.equals(enteredPassword);
    }

    // Define the toDataString method in the User class
    public String toDataString() {
        return userId + "," + userPsw;
    }
    
    
    
}
