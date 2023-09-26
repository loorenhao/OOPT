/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopt;


import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author USER
 */
public class Oopt {
    
    public static final String STAFF_FILE = "src/data1/staff.txt";
    public static final String MEMBER_FILE = "src/data1/member.txt";
    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CheckFile.begin();
        
    try {
    Thread.sleep(2); // Sleep for 2 seconds
    } catch (InterruptedException e) {
            // Handle any exceptions here
    }

    boolean continueUsingSystem = true;

     while (continueUsingSystem) {
        FIrstMenu.menu1();
        System.out.print("Do You Want To Continue To Use The System? (yes/no): ");
        String userInput = sc.next().toLowerCase();

        if (userInput.equals("no")) {
            continueUsingSystem = false;
        }
    

   }
    
    
    }   
}
