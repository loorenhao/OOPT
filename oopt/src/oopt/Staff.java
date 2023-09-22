/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

/**
 *
 * @author USER
 */
public class Staff extends User {
    private String Position;
    
    public Staff(String userId, String userPsw) {
        super(userId, userPsw);
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }
    
    @Override
    public String toDataString() {
    return getUserId() + "," + getUserPsw() + "," + getPosition();
    }
    
    
    
}