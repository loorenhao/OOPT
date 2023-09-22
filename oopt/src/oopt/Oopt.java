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
   
    
    
        FIrstMenu.menu1();

//        int cusMenuSelect;
//        while (true) {
//            System.out.printf("\nMain Menu\n1. Customer Details\n2. Product Menu\n3. Cart\n4. Checkout\n5. Exit\n\nEnter your choice > "); // 1 > View & Modify CusDetails ;2 > View ProdMenu,Add Prod ;3 > Show & Modify Cart;4 > Make payment;5 > exitprogram/logout
//            cusMenuSelect = sc.nextInt();
//            switch (cusMenuSelect) {
//   //             case 1 -> CustomerDetails();
//               case 2 -> CusProductMenu();
////                case 3 -> {
////                }
////                case 4 -> {
////                }
////                case 5 -> Menu.mainMenu();
//                default ->
//                    System.out.println("\nInvalid Input! Pls enter 1~5!");
//            }
//
//            System.out.print("Enter staff job position: ");
//        }
//    }
    
    
//    private static void CusProductMenu() {
//        
//        do {
//            System.out.printf(" \nProduct Menu \n1. Display all Product\n2. Search Product\n3. Purchase Product\n4. Exit\nEnter your choice > ");
//            int choice = sc.nextInt();
//            sc.nextLine();
//            System.out.printf("\n");
//            switch (choice) {
////                case 1 -> cusDisplayAllProduct();
////                case 2 -> cusSearchProductModule();
////                case 3 -> cusPurchaseModule();
////                case 4 -> customerMenu();
//                default -> System.out.println("\nInvalid Input! Pls enter 1~4!");
//            }
//        } while (true);
//
   }
    
    
    
}
