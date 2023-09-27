/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;



/**
 *
 * @author USER
 */
public class CusMenu {






    public static void cusMenu() {
        ShoppingCart cart8 = new ShoppingCart();
        int cusMenuSelect;
        do {
            System.out.printf("\nMain Menu\n1. Product Menu\n2. Exit\n\nEnter your choice > "); // 1 > View & Modify CusDetails ;2 > View ProdMenu,Add Prod ;3 > Show & Modify Cart;4 > Make payment;5 > exitprogram/logout
            cusMenuSelect = Validation.getIntInput();
            switch (cusMenuSelect) {

                case 1 -> {
                    CusProductMenu();
                }
  
                case 2 ->
                    FIrstMenu.menu1();
                default ->
                    System.out.println("\nInvalid Input! Pls enter 1~2!");
            }
        } while (true);

    }

    private static void CusProductMenu() {
        
        int choice;
        do {
            System.out.printf(" \nProduct Menu \n1. Display All Product\n2. Search Product\n3. Purchase Product\n4. Exit\nEnter your choice > ");
            choice = Validation.getIntInput();
            System.out.printf("\n");
            switch (choice) {
                case 1 -> {
                    Product.CusDisplayAllProduct();
                }
                case 2 -> {
                    Product.cusSearchProductModule();
                }
                case 3 -> {
                    Product.cusPurchaseModule();
                }
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println("\nInvalid Input! Pls enter 1~4!");
                }
            }
        } while (true);

    }
    

    } 






    
   

