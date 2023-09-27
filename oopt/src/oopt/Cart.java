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

    private String prodID;		 //productID
    private String prodName;         //productName
    private String category;        //productCategory
    private int prodqty;		 //productQuantity
    private double prodPrice;        //productPricePerUnit

    public Cart(String prodName, String category, int prodqty, double prodPrice, String prodID) {
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

//    public void addCart(String prodid){
//        this.prodName=getname();
//    }
    
    
    

}
