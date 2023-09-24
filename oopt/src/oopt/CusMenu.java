/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CusMenu {
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void cusMenu() {
        int cusMenuSelect;
        do {
            System.out.printf("\nMain Menu\n1. Customer Details\n2. Product Menu\n3. Cart\n4. Checkout\n5. Exit\n\nEnter your choice > "); // 1 > View & Modify CusDetails ;2 > View ProdMenu,Add Prod ;3 > Show & Modify Cart;4 > Make payment;5 > exitprogram/logout
            cusMenuSelect = sc.nextInt();
            switch (cusMenuSelect) {
                case 1 -> {//CustomerDetails(); (kuanhong)
                }
                case 2 -> {CusProductMenu();
                }
                case 3 -> {//Cart(); (renhao)
                }
                case 4 -> {//Checkout(); (renhao)
                }
                case 5 -> FIrstMenu.menu1();
                default -> System.out.println("\nInvalid Input! Pls enter 1~5!");
            }
                    } while (true);

    }
    
    
    private static void CusProductMenu() {
        int choice;
        do {
            System.out.printf(" \nProduct Menu \n1. Display All Product\n2. Search Product\n3. Purchase Product\n4. Exit\nEnter your choice > ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.printf("\n");
            switch (choice) {
                case 1 -> {CusDisplayAllProduct();
                }
                case 2 -> {cusSearchProductModule();
                }
                case 3 -> {cusPurchaseModule();
                }
                case 4 -> {return;  
                }
                default -> {System.out.println("\nInvalid Input! Pls enter 1~4!");
                }
            }
        } while (true);

    }
    
    private static void CusDisplayAllProduct(){
            custProdMenuHeading();
            CusProduct();
            System.out.printf("╚═══════════╩═══════════════════════════╩═══════════════╩═══════════════╝\nPress enter to continue...");
            new java.util.Scanner(System.in).nextLine();
    }
    
    private static void custProdMenuHeading(){
        String l1 = "\n╔═══════════╦═══════════════════════════╦═══════════════╦═══════════════╗";
        String l2=  "\n║ ProductID ║   Product Name            ║    Category   ║ PricePerUnit  ║";
        String l3 = "\n╠═══════════╬═══════════════════════════╬═══════════════╬═══════════════╣";
 
        
        try {
            System.setOut(new PrintStream(System.out, true, "UTF8"));
            System.out.println(l1 + l2 + l3);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Oopt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void CusProduct() {
        String CusProductFile = "src/data1/product.txt"; 
        try (BufferedReader br = new BufferedReader(new FileReader(CusProductFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into values using a delimiter (e.g., "|")
                String[] parts = line.split("\\|");
                
                // Ensure that the line has the expected number of parts
                if (parts.length == 6) {
                    // extract value
                    String productId = parts[0].trim();
                    String productName = parts[1].trim();
                    String category = parts[2].trim();
                    //int quantity = Integer.parseInt(parts[3].trim());
                    double price = Double.parseDouble(parts[4].trim());
                    //double netPrice = Double.parseDouble(parts[5].trim());
                    //display product details  
                    System.out.printf("║   %-8s║   %-24s║ %-13s ║     %-10.2f║\n", productId, productName, category, price);     //dont show quantity & netprice
                } else {
                    // Handle lines with incorrect formatting, if needed
                    System.out.println("Skipping line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    
    
    private static void cusSearchProductModule(){
        int choice;
        do{
        System.out.printf("Search Page\nCategory List\n1. Stationery\n2. Sport\n3. Furniture\n4. Food\n5. Kitchen\nEnter number to search specify product > ");
        choice = sc.nextInt();
        }while(!Validation.CheckMinMax(choice, 1, 5));
        searchProductsByCategory(choice);
        
        
    }
    
    private static void searchProductsByCategory(int categoryChoice) {
    String category;

    switch (categoryChoice) {
        case 1 -> category = "stationery";
        case 2 -> category = "sport";
        case 3 -> category = "furniture";
        case 4 -> category = "food";
        case 5 -> category = "kitchen";
        default -> {
            return; 
            }
    }

    System.out.println("Products in the " + category + " category:");
    String CusProductFile = "src/data1/product.txt"; 
    try (BufferedReader br = new BufferedReader(new FileReader(CusProductFile))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 6 && parts[2].trim().equalsIgnoreCase(category)) {
                // Display product detail
                String productId = parts[0].trim();
                String productName = parts[1].trim();
                double price = Double.parseDouble(parts[4].trim());

                System.out.printf("Product ID: %-8s | Product Name: %-24s | Price: %.2f%n", productId, productName, price);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }
    System.out.printf("\nPress enter to continue...");
            new java.util.Scanner(System.in).nextLine();
}
 
    
    private static void cusPurchaseModule(){
        boolean validProdID;
        boolean validProdQty;
        String inputProdID;
        int inputProdQty;
        int addMoreFlag = 0;
        int choice;
        System.out.printf("Order Page\n");
        do{
           do {
                  System.out.printf("Enter ProductID (e.g. P1001) to add to cart > ");
                  inputProdID = sc.nextLine(); // Get user input inside the loop
                  validProdID = Validation.checkProductID(inputProdID); // Check the validity of the entered ProductID

           if (!validProdID) { // Check if the ProductID is invalid
             System.out.println("\nInvalid ProductID! Please enter again.\n");
               }
            } while (!validProdID); // loop until ProductID is valid
           do{
           System.out.printf("Enter Quantity > ");
           inputProdQty = sc.nextInt();
           sc.nextLine();
           }while(inputProdQty < 0 );
           validProdQty = Validation.checkQuantity(inputProdID,inputProdQty);
           if(validProdQty){
              //addToCart(); (renhao)
           System.out.printf("\nProduct is added to the cart!\nAdd more product? (1 = Yes / 2 = No) > ");
           choice = sc.nextInt();
           switch(choice){
               case 1 ->{break;
               }
               case 2 -> {addMoreFlag = 1;
                           break;
               }
               default -> System.out.println("\nInvalid input!Pls enter 1~2");  
           }
           }else{
                System.out.println("Product's stock is not enough!\n");
                }
          }while(addMoreFlag != 1);
        
           
    }

          
    
    
    
    
}
