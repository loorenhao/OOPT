/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class StaffMenu {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void staffMenu() {
         int staffMenuSelect;
        do {
            System.out.printf("\nMain Menu\n1. Staff Details\n2. Product Menu\n3. Modify Product\n4. Exit\n\nEnter your choice > ");
            staffMenuSelect = sc.nextInt();
            switch (staffMenuSelect) {
                case 1 -> {//Staff();
                }
                case 2 -> {StaffProductMenu();
                }
                case 3 -> {ModifyProduct(); 
                }
                case 4 -> FIrstMenu.menu1();
                default -> System.out.println("\nInvalid Input! Pls enter 1~4!");
            }
                    } while (true);
    }
    
       private static void StaffProductMenu() {
        int choice;
        do {
            System.out.printf(" \nProduct Menu \n1. Display All Product\n2. Search Product\n3. Exit\nEnter your choice > ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.printf("\n");
            switch (choice) {
                case 1 -> {staffDisplayAllProduct();
                }
                case 2 -> {staffSearchProductModule();
                }
                case 3 -> {return;  
                }
                default -> {System.out.println("\nInvalid Input! Pls enter 1~3!");
                }
            }
        } while (true);

    }
    
       
       
       
       private static void staffDisplayAllProduct(){
            StaffProdMenuHeading();
            StaffProduct();
            System.out.printf("╚═══════════╩═══════════════════════════╩═══════════════╩═══════════════╩═══════════════╩═════════╝\nPress enter to continue...");
            new java.util.Scanner(System.in).nextLine();
    }
    
    private static void StaffProdMenuHeading(){
        String l1 = "\n╔═══════════╦═══════════════════════════╦═══════════════╦═══════════════╦═══════════════╦═════════╗";
        String l2=  "\n║ ProductID ║   Product Name            ║    Category   ║   GrossPrice  ║   NetPrice    ║  Stock  ║";
        String l3 = "\n╠═══════════╬═══════════════════════════╬═══════════════╬═══════════════╬═══════════════╬═════════╣";
 
        
        try {
            System.setOut(new PrintStream(System.out, true, "UTF8"));
            System.out.println(l1 + l2 + l3);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Oopt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void StaffProduct() {
        String StaffProductFile = "src/data1/product.txt"; 
        try (BufferedReader br = new BufferedReader(new FileReader(StaffProductFile))) {
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
                    int quantity = Integer.parseInt(parts[3].trim());
                    double price = Double.parseDouble(parts[4].trim());
                    double netPrice = Double.parseDouble(parts[5].trim());
                    //display product details  
                    System.out.printf("║   %-8s║   %-24s║   %-11s ║     %-10.2f║     %-10.2f║    %-3d  ║\n", productId, productName, category, price,netPrice,quantity);     // show quantity & netprice
                } else {
                    // Handle lines with incorrect formatting, if needed
                    System.out.println("Skipping line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    
    
    private static void staffSearchProductModule(){
        int choice;
        do{
        System.out.printf("Search Page\nCategory List\n1. Stationery\n2. Sport\n3. Furniture\n4. Food\n5. Kitchen\nEnter number to search specify product > ");
        choice = sc.nextInt();
        sc.nextLine();
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
    String StaffProductFile = "src/data1/product.txt"; 
    try (BufferedReader br = new BufferedReader(new FileReader(StaffProductFile))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 6 && parts[2].trim().equalsIgnoreCase(category)) {
                // Display product detail
                String productId = parts[0].trim();
                String productName = parts[1].trim();
                int quantity = Integer.parseInt(parts[3].trim());
                double price = Double.parseDouble(parts[4].trim());
                double netPrice = Double.parseDouble(parts[5].trim());
                System.out.printf("Product ID: %-5s | Product Name: %-24s | GrossPrice: %-6.2f | NetPrice: %-6.2f | Stock: %-3d\n", productId, productName, price,netPrice,quantity);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }
    System.out.printf("\nPress enter to continue...");
            new java.util.Scanner(System.in).nextLine();
}
       
    private static void ModifyProduct(){
        int choice;
        do{
        System.out.printf("\nModify Product\n1. Update Stock\n2. Update GrossPrice\n3. Update NetPrice\n4. Exit\nEnter your choice > ");
        choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice){
            case 1 -> StaffUpdateStock();
            case 2 -> StaffUpdateGrossPrice();
            case 3 -> StaffUpdateNetPrice();
            case 4 -> {return;}
            default -> System.out.println("\nInvalid Input! Pls enter 1~4!"); 
    }
        }while(true);
    }
    private static void StaffUpdateStock(){
        boolean validProdID;
        String inputProdID;
        int newStockQuantity;
       
        do{
        System.out.printf("\nUpdate Stock\nEnter ProductID (e.g. P1001) to update stock > ");
        inputProdID = sc.nextLine();
        validProdID = Validation.checkProductID(inputProdID);
        
        if(!validProdID){
            System.out.println("\nInvalid ProductID! Please enter again.\n");}
        }while(!validProdID);
        
        do{
        System.out.printf("Enter new stock quantity (maximum 999)> ");
        newStockQuantity = sc.nextInt();
        sc.nextLine();
        if(newStockQuantity >= 0 && newStockQuantity <= 999){
            break;
        }else 
            System.out.printf("\nInvalid Input! Pls enter 0~999!\n");
        }while(true);
        String productFilePath = "src/data1/product.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(productFilePath))) {
            StringBuilder updatedContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 6) {
                    String productID = parts[0].trim();

                    if (productID.equals(inputProdID)) {
                        parts[3] = Integer.toString(newStockQuantity);
                    }
                    
                    String updatedLine = String.join("|", parts);
                    updatedContent.append(updatedLine).append("\n");
                } else {
                    updatedContent.append(line).append("\n");
                }
            }
            
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(productFilePath))) {
                writer.print(updatedContent.toString());
            }

            System.out.println("Stock updated successfully!");
        } catch (IOException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        }
        }
    

    private static void StaffUpdateGrossPrice(){
        boolean validProdID;
        String inputProdID;
        double newGrossPrice;
       
        do{
        System.out.printf("\nUpdate Gross Price\nEnter ProductID (e.g. P1001) to update Gross Price > ");
        inputProdID = sc.nextLine();
        validProdID = Validation.checkProductID(inputProdID);
        
        if(!validProdID){
        System.out.println("\nInvalid ProductID! Please enter again.\n");}
        }while(!validProdID);
        
        do{
        System.out.printf("Enter new Gross Price > ");
        newGrossPrice = sc.nextDouble();
        sc.nextLine();
        if(newGrossPrice >= 0.01 ){
            break;
        }else 
            System.out.printf("\nInvalid Input! Pls enter price above 0.01!\n");
        }while(true);
        String productFilePath = "src/data1/product.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(productFilePath))) {
            StringBuilder updatedContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 6) {
                    String productID = parts[0].trim();

                    if (productID.equals(inputProdID)) {
                        parts[4] = Double.toString(newGrossPrice);
                    }
                    
                    String updatedLine = String.join("|", parts);
                    updatedContent.append(updatedLine).append("\n");
                } else {
                    updatedContent.append(line).append("\n");
                }
            }
            
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(productFilePath))) {
                writer.print(updatedContent.toString());
            }

            System.out.println("Gross Price updated successfully!");
        } catch (IOException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        }
    }
    
    private static void StaffUpdateNetPrice(){
        boolean validProdID;
        String inputProdID;
        double newNetPrice;
       
        do{
        System.out.printf("\nUpdate Net Price\nEnter ProductID (e.g. P1001) to update Net Price > ");
        inputProdID = sc.nextLine();
        validProdID = Validation.checkProductID(inputProdID);
        
        if(!validProdID){
        System.out.println("\nInvalid ProductID! Please enter again.\n");}
        }while(!validProdID);
        
        do{
        System.out.printf("Enter new Net Price > ");
        newNetPrice = sc.nextDouble();
        sc.nextLine();
        if(newNetPrice >= 0.01 ){
            break;
        }else 
            System.out.printf("\nInvalid Input! Pls enter price above 0.01!\n");
        }while(true);
        String productFilePath = "src/data1/product.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(productFilePath))) {
            StringBuilder updatedContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 6) {
                    String productID = parts[0].trim();

                    if (productID.equals(inputProdID)) {
                        parts[5] = Double.toString(newNetPrice);
                    }
                    
                    String updatedLine = String.join("|", parts);
                    updatedContent.append(updatedLine).append("\n");
                } else {
                    updatedContent.append(line).append("\n");
                }
            }
            
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(productFilePath))) {
                writer.print(updatedContent.toString());
            }

            System.out.println("Net Price updated successfully!");
        } catch (IOException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        }
    }
}
