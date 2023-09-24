/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author USER
 */
public class Product {
    //product info
	private String prodID;		 //productID
        private String prodName;	 //productName
	private String category;	 //productCategory
        private int prodqty;		 //productQuantity
        private double prodPrice;	 //productPricePerUnit
	private static int prodNum;
	
	//Inventory
	private double netPrice;          //product批发价/净价
	


public Product(){			//空参
	
}


public Product(String prodName,String category,int prodqty,double prodPrice,double netPrice){
	prodNum++;	
	int id = 1000 + prodNum;						
	this.prodID = "P" + Integer.toString(id);		//prodID = P1001
	this.prodName = prodName;
	this.prodqty = prodqty;
	this.category = category;
	this.prodPrice = prodPrice;
	this.netPrice = netPrice;
}

//setter & getter
public String getprodID(){
	return prodID;
}

public void setprodID(String prodID){
	this.prodID = prodID;
}

public String getprodName(){
	return prodName;
}

public void setprodName(String prodName){
	this.prodName = prodName;
}

public String getcategory(){
	return category;
}

public void setcategory(String category){
	this.category = category;
}

public int getprodqty(){
	return prodqty;
}

public void setprodqty(int prodqty){
	this.prodqty = prodqty;
}

public double getprodPrice(){
	return prodPrice;
}

public void setprodPrice(double prodPrice){
	this.prodPrice = prodPrice;
}

public double getnetPrice(){
	return netPrice;
}

public void setnetPrice(double netPrice){
	this.netPrice = netPrice;
}

 /**
 * @return
 */
public static int getprodNum() {
        return prodNum; 
	}
    
    
    
  
//private static void Product1(){
//    //Product
//    Product[] product = new Product[100];
//    //stationery Category
//    product[Product.getprodNum()] = new Product("Marker Pen            ", "stationery", 12, 8.12, 6.82);
//    product[Product.getprodNum()] = new Product("Topvalu A4            ", "stationery", 21, 11.9, 10.9);
//    product[Product.getprodNum()] = new Product("Management File       ", "stationery", 4, 2.50, 2.0);
//    product[Product.getprodNum()] = new Product("Artist Brush          ", "stationery", 23, 8.90, 6.220);
//    product[Product.getprodNum()] = new Product("Glitter Glue          ", "stationery", 15, 17.90, 15.00);
//
//    //sport Category
//    product[Product.getprodNum()] = new Product("Football              ", "  sport   ", 24, 81.16, 61.22);
//    product[Product.getprodNum()] = new Product("Basketball            ", "  sport   ", 30, 45.23, 40.00);
//    product[Product.getprodNum()] = new Product("Badminton Racquet     ", "  sport   ", 4, 210.64, 190.00);
//    product[Product.getprodNum()] = new Product("Baseball              ", "  sport   ", 8, 98.23, 90.00);
//    product[Product.getprodNum()] = new Product("Nike Shoes            ", "  sport   ", 14, 108.97, 100.82);
//
//    //furniture Category
//    product[Product.getprodNum()] = new Product("Dining Table          ", "furniture ", 19, 8.12, 6.82);
//    product[Product.getprodNum()] = new Product("Sofa Bed              ", "furniture ", 3, 290.64, 250.00);
//    product[Product.getprodNum()] = new Product("Wood Chair            ", "furniture ", 12, 49.99, 39.82);
//    product[Product.getprodNum()] = new Product("Wood Table            ", "furniture ", 9, 85.68, 76.15);
//    product[Product.getprodNum()] = new Product("Curtain               ", "furniture ", 5, 42.32, 36.00);
//
//    //food Category
//    product[Product.getprodNum()] = new Product("Gardenia              ", "  food    ", 19, 2.11, 1.99);
//    product[Product.getprodNum()] = new Product("Massimo               ", "  food    ", 32, 2.40, 2.00);
//    product[Product.getprodNum()] = new Product("Cheese Bread          ", "  food    ", 45, 3.99, 3.00);
//    product[Product.getprodNum()] = new Product("Sushi Onigiri         ", "  food    ", 23, 4.99, 4.98);
//    product[Product.getprodNum()] = new Product("Chocolate Croissant   ", "  food    ", 14, 2.33, 2.10);
//
//    //Kitchen Appliance Category
//    product[Product.getprodNum()] = new Product("Panasonic Blender     ", " kitchen  ", 13, 95.00, 79.00);
//    product[Product.getprodNum()] = new Product("Pensonic Rice Cooker  ", " kitchen  ", 2, 79.00, 69.00);
//    product[Product.getprodNum()] = new Product("Khind Jug Kettle      ", " kitchen  ", 6, 45.00, 39.00);
//    product[Product.getprodNum()] = new Product("Midea Induction Cooker", " kitchen  ", 10, 120.00, 100.00);
//    product[Product.getprodNum()] = new Product("Faber Air Fryer       ", " kitchen  ", 3, 229.00, 200.00);
//
//    try {
//        FileWriter fw = new FileWriter("src/data/Product.txt"); // Create the file
//        //Write the product details to the file
//        try (PrintWriter pw = new PrintWriter(fw)) {
//            //Write the product details to the file
//            for (int i = 0; i < Product.getprodNum(); i++) {
//                pw.printf(product[i].getprodID() + "|" + product[i].getprodName() + "|"  + product[i].getcategory() + "|"  + product[i].getprodqty() + "|" + product[i].getprodPrice() + "|" + product[i].getnetPrice() + "\n");
//            }
//            // Close the PrintWriter
//        }
//    } catch (IOException e) {
//        System.out.println("Error: " + e.getMessage());
//    }
//
//}
}
