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
public class FIrstMenu {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void menu1() {
        int temp;
        
        do {
            System.out.println("Do you want to:");
            System.out.println("1. LOG IN");
            System.out.println("2. REGISTER ");
            System.out.print("CHOICE > ");
            
            temp =  sc.nextInt();
           
        } while (!Validation.CheckMinMax(temp,1,2));
        
          switch (temp) {
                case 1 -> loginMenu();
                case 2 -> registerMenu();
        }
          
    }
    
    
    
    private static void loginMenu() {
        int temp;
        
        do {
            System.out.println("\nWhat do you want to log in as:");
            System.out.println("1. STAFF/CUSTOMER");
            System.out.println("2. GUEST");
            System.out.println("3. testouput staffmenu");
            System.out.print("CHOICE > ");
            
            temp =  sc.nextInt();
           
        } while (!Validation.CheckMinMax(temp,1,3));
        
        switch (temp) {
               case 1 -> LogIn.LogInUser();
               case 2 -> CusMenu.cusMenu();
               case 3 -> StaffMenu.staffMenu();     //this is for test output staffMenu
               
        }
    }
    
    
    
    private static void registerMenu() {
        int temp;
        
        do {
            System.out.println("\nWhat do you want to register as:");
            System.out.println("1. STAFF");
            System.out.println("2. MEMBER");
            System.out.print("CHOICE > ");
            
            temp = sc.nextInt();
            
           
        } while (!Validation.CheckMinMax(temp,1,2));
        
         switch (temp) {
               case 1 -> Registration.registerStaff();
               case 2 -> Registration.registerMember();
               
            }
    }
}
