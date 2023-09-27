/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

/**
 *
 * @author USER
 */

public class Cart {
    //product info

    //private final List<Cart> shop;

    private String prodID;		 //productID
    private String prodName;         //productName
    private String category;        //productCategory
    private int prodqty=0;		 //productQuantity
    private double prodPrice;        //productPricePerUnit

    private static int num3 = 5;
    private Product product;
    private int quantity;

    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    Cart(String inputProdID, int inputProdQty, String prodName, String category, double price) {
        this.prodID = inputProdID;		//prodID = P1001
        this.prodName = prodName;
        this.prodqty += inputProdQty;
        this.category = category;
        this.prodPrice = price;
    }



    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void Cart(String prodID, int prodqty, String prodName, String category, double prodPrice) {
        this.prodID = prodID;		//prodID = P1001
        this.prodName = prodName;
        this.prodqty = prodqty;
        this.category = category;
        this.prodPrice = prodPrice;
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





    @Override
    public String toString() {
        return "ProdID: " + prodID + ", Name: " + prodName + ", Category: " + category + ", Price: RM" + prodPrice + ", Quantity: " + prodqty +"  \n";
      
    }
    
    

    
}
