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

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileHandle.checkFile();
        //Formater.clearScreen();

        try {
            Thread.sleep(2); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            // Handle any exceptions here
        }

         
        boolean continueUsingSystem = true;
        
        while (continueUsingSystem) {
            FIrstMenu.menu1();
            boolean isNoError = true;
            while (!isNoError) {
                System.out.print("Do You Want To Continue To Use The System? (yes/no): ");
                String userInput = sc.next().toLowerCase();

                if (userInput.equals("no")) {
                    continueUsingSystem = false;
                    isNoError = true;
                } else if (userInput.equals("yes")) {
                    continueUsingSystem = true;
                    isNoError = true;
                } else {
                    System.out.println("Invalid Input!");
                    isNoError = false;
                }
            }

        }

    }

    public static void exit() {
        System.out.println("TQ using over system");
        System.exit(0); // 0 indicates a normal, successful termination
    
    }


}
