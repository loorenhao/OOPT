/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class Product {

    private static final Scanner sc = new Scanner(System.in);
    //product info
    private String prodID;		 //productID
    private String prodName;	 //productName
    private String category;	 //productCategory
    private int prodqty;		 //productQuantity
    private double prodPrice;	 //productPricePerUnit
    private static int prodNum;
    //Inventory
    private double netPrice;          //product批发价/净价

    public Product() {			//空参

    }

    public Product(String prodName, String category, int prodqty, double prodPrice, double netPrice, String prodID) {
        prodNum++;
        this.prodID = prodID;		//prodID = P1001
        this.prodName = prodName;
        this.prodqty = prodqty;
        this.category = category;
        this.prodPrice = prodPrice;
        this.netPrice = netPrice;
    }

//setter & getter
    public String getprodID() {
        return prodID;
    }

    public void setprodID(String prodID) {
        this.prodID = prodID;
    }

    public String getprodName() {
        return prodName;
    }

    public void setprodName(String prodName) {
        this.prodName = prodName;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public int getprodqty() {
        return prodqty;
    }

    public void setprodqty(int prodqty) {
        this.prodqty = prodqty;
    }

    public double getprodPrice() {
        return prodPrice;
    }

    public void setprodPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public double getnetPrice() {
        return netPrice;
    }

    public void setnetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    /**
     * @return
     */
    public static int getprodNum() {
        return prodNum;
    }

    public static void CusDisplayAllProduct() {
        custProdMenuHeading();
        CusProduct();
        System.out.printf("╚═══════════╩═══════════════════════════╩═══════════════╩═══════════════╝\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    private static void custProdMenuHeading() {
        String l1 = "\n╔═══════════╦═══════════════════════════╦═══════════════╦═══════════════╗";
        String l2 = "\n║ ProductID ║   Product Name            ║    Category   ║ PricePerUnit  ║";
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
                String[] parts = line.split("\\|");
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
                    System.out.println("Skipping line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void cusSearchProductModule() {
        int choice;
        do {
            System.out.printf("Search Page\nCategory List\n1. Stationery\n2. Sport\n3. Furniture\n4. Food\n5. Kitchen\nEnter number to search specify product > ");
            choice = sc.nextInt();
            sc.nextLine();
        } while (!Validation.CheckMinMax(choice, 1, 5));
        cusSearchProductsByCategory(choice);

    }

    private static void cusSearchProductsByCategory(int categoryChoice) {
        String category;

        switch (categoryChoice) {
            case 1 ->
                category = "stationery";
            case 2 ->
                category = "sport";
            case 3 ->
                category = "furniture";
            case 4 ->
                category = "food";
            case 5 ->
                category = "kitchen";
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

    public static void cusPurchaseModule() {
        ShoppingCart cart7 = new ShoppingCart();
        boolean validProdID;
        boolean validProdQty;
        String inputProdID;
        int inputProdQty;
        int addMoreFlag = 0;
        int choice;
        String CusProductFile = "src/data1/product.txt";
        String category = null;
        String prodName = null;
        double price = 0;
        int ttlamm = 0;

        System.out.printf("Order Page\n");
        do {
            do {
                System.out.printf("Enter ProductID (e.g. P1001) to add to cart > ");
                inputProdID = sc.nextLine();
                validProdID = Validation.checkProductID(inputProdID);

                if (!validProdID) { // Check if the ProductID is invalid
                    System.out.println("\nInvalid ProductID! Please enter again.\n");
                }

            } while (!validProdID); // loop until ProductID is valid

            do {
                System.out.printf("Enter Quantity > ");
                inputProdQty = Validation.getIntInput();
            } while (!Validation.CheckMin(inputProdQty, 0));

            validProdQty = Validation.checkQuantity(inputProdID, inputProdQty);
            if (validProdQty) {

                try (BufferedReader br = new BufferedReader(new FileReader(CusProductFile))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("\\|");
                        if (parts.length == 6 && parts[0].trim().equalsIgnoreCase(inputProdID)) {
                            // Display product detail
                            prodName = parts[1].trim();
                            category = parts[2].trim();

                            price = Double.parseDouble(parts[4].trim());

                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading the file: " + e.getMessage());
                }

                Cart cart3 = new Cart(inputProdID, inputProdQty, prodName, category, price);
                cart7.addToCart(cart3);
                cart7.displayCart();
                ttlamm += inputProdQty;
                System.out.printf("\nProduct is added to the cart!\nAdd more product? (1 = Yes / 2 = No) > ");
                choice = Validation.getIntInput();

                switch (choice) {
                    case 1 -> {

                    }
                    case 2 -> {
                        addMoreFlag = 1;

                    }
                    default ->
                        System.out.println("\nInvalid input!Pls enter 1~2");
                }
            } else {
                System.out.println("Product's stock is not enough!\n");
            }
        } while (addMoreFlag != 1);

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a format for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format and display the current date and time
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time : " + formattedDateTime);

        //start payment 
        cart7.displayCart();
        double total2 = cart7.calculateTotalPrice();

        System.out.printf("Total Quantity :                 %d\n", ttlamm);
        System.out.printf("Subtotal       :               RM%.2f", total2);

        int point = (int) (total2 / 5);
        System.out.printf("\nYou get %d of Loyalthy point", point);

        
//        String productFilePath = "src/data1/report.txt";
//        String patternToMatch = "RM\\d+\\.\\d{2}"; // Regular expression to match "RM" followed by one or more digits
//        try (BufferedReader br = new BufferedReader(new FileReader(productFilePath))) {
//            double finalttlamm = 0;
//            Pattern pattern = Pattern.compile(patternToMatch);
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                Matcher matcher = pattern.matcher(line);
//                while (matcher.find()) {
//                    String matchedValue = matcher.group();
//
//                   
//                    finalttlamm = Double.parseDouble(matchedValue);
//                    finalttlamm +=ttlamm;
//                     System.out.println("Error updating report: " + finalttlamm);
//                    try (PrintWriter writer = new PrintWriter(new FileWriter(productFilePath))) {
//                        writer.print(Double.toString(finalttlamm));
//                            
//                    } catch (IOException e) {
//                        System.out.println("Error updating report: " + e.getMessage());
//                    }
//                }
//                // Check if the line contains any stop words
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    reduceStock(inputProdID,inputProdQty);
    }
    
     private static void reduceStock(String prodID,int qty) {
        String productFilePath = "src/data1/product.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(productFilePath))) {
            StringBuilder updatedContent = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 6) {
                    String productID = parts[0].trim();
                    int qtybefore = Integer.parseInt(parts[3].trim());
                    qtybefore = qtybefore-qty;
                    if (productID.equals(prodID)) {
                        parts[3] = Integer.toString(qtybefore);
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
     
     

    public static void staffDisplayAllProduct() {
        StaffProdMenuHeading();
        StaffProduct();
        System.out.printf("╚═══════════╩═══════════════════════════╩═══════════════╩═══════════════╩═══════════════╩═════════╝\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    private static void StaffProdMenuHeading() {
        String l1 = "\n╔═══════════╦═══════════════════════════╦═══════════════╦═══════════════╦═══════════════╦═════════╗";
        String l2 = "\n║ ProductID ║   Product Name            ║    Category   ║   GrossPrice  ║   NetPrice    ║  Stock  ║";
        String l3 = "\n╠═══════════╬═══════════════════════════╬═══════════════╬═══════════════╬═══════════════╬═════════╣";

        try {
            System.setOut(new PrintStream(System.out, true, "UTF8"));
            System.out.println(l1 + l2 + l3);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Oopt.class
                    .getName()).log(Level.SEVERE, null, ex);
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
                    System.out.printf("║   %-8s║   %-24s║   %-11s ║     %-10.2f║     %-10.2f║    %-3d  ║\n", productId, productName, category, price, netPrice, quantity);     // show quantity & netprice
                } else {
                    // Handle lines with incorrect formatting, if needed
                    System.out.println("Skipping line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void staffSearchProductModule() {
        int choice;
        do {
            System.out.printf("Search Page\nCategory List\n1. Stationery\n2. Sport\n3. Furniture\n4. Food\n5. Kitchen\nEnter number to search specify product > ");
            choice = sc.nextInt();
            sc.nextLine();
        } while (!Validation.CheckMinMax(choice, 1, 5));
        staffSearchProductsByCategory(choice);

    }

    private static void staffSearchProductsByCategory(int categoryChoice) {
        String category;

        switch (categoryChoice) {
            case 1 ->
                category = "stationery";
            case 2 ->
                category = "sport";
            case 3 ->
                category = "furniture";
            case 4 ->
                category = "food";
            case 5 ->
                category = "kitchen";
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
                    System.out.printf("Product ID: %-5s | Product Name: %-24s | GrossPrice: %-6.2f | NetPrice: %-6.2f | Stock: %-3d\n", productId, productName, price, netPrice, quantity);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        System.out.printf("\nPress enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void ModifyProduct() {
        int choice;
        do {
            System.out.printf("\nModify Product\n1. Update Stock\n2. Update GrossPrice\n3. Update NetPrice\n4. Exit\nEnter your choice > ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 ->
                    StaffUpdateStock();
                case 2 ->
                    StaffUpdateGrossPrice();
                case 3 ->
                    StaffUpdateNetPrice();
                case 4 -> {
                    return;
                }
                default ->
                    System.out.println("\nInvalid Input! Pls enter 1~4!");
            }
        } while (true);
    }

    private static void StaffUpdateStock() {
        boolean validProdID;
        String inputProdID;
        int newStockQuantity;

        do {
            System.out.printf("\nUpdate Stock\nEnter ProductID (e.g. P1001) to update stock > ");
            inputProdID = sc.nextLine();
            validProdID = Validation.checkProductID(inputProdID);

            if (!validProdID) {
                System.out.println("\nInvalid ProductID! Please enter again.\n");
            }
        } while (!validProdID);

        do {
            System.out.printf("Enter new stock quantity (maximum 999)> ");
            newStockQuantity = sc.nextInt();
            sc.nextLine();
            if (newStockQuantity >= 0 && newStockQuantity <= 999) {
                break;
            } else {
                System.out.printf("\nInvalid Input! Pls enter 0~999!\n");
            }
        } while (true);
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

    private static void StaffUpdateGrossPrice() {
        boolean validProdID;
        String inputProdID;
        double newGrossPrice;

        do {
            System.out.printf("\nUpdate Gross Price\nEnter ProductID (e.g. P1001) to update Gross Price > ");
            inputProdID = sc.nextLine();
            validProdID = Validation.checkProductID(inputProdID);

            if (!validProdID) {
                System.out.println("\nInvalid ProductID! Please enter again.\n");
            }
        } while (!validProdID);

        do {
            System.out.printf("Enter new Gross Price > ");
            newGrossPrice = sc.nextDouble();
            sc.nextLine();
            if (newGrossPrice >= 0.01) {
                break;
            } else {
                System.out.printf("\nInvalid Input! Pls enter price above 0.01!\n");
            }
        } while (true);
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

    private static void StaffUpdateNetPrice() {
        boolean validProdID;
        String inputProdID;
        double newNetPrice;

        do {
            System.out.printf("\nUpdate Net Price\nEnter ProductID (e.g. P1001) to update Net Price > ");
            inputProdID = sc.nextLine();
            validProdID = Validation.checkProductID(inputProdID);

            if (!validProdID) {
                System.out.println("\nInvalid ProductID! Please enter again.\n");
            }
        } while (!validProdID);

        do {
            System.out.printf("Enter new Net Price > ");
            newNetPrice = sc.nextDouble();
            sc.nextLine();
            if (newNetPrice >= 0.01) {
                break;
            } else {
                System.out.printf("\nInvalid Input! Pls enter price above 0.01!\n");
            }
        } while (true);
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
