///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package oopt;

import java.util.ArrayList;
import java.util.List;

///**
// *
// * @author USER

import java.util.List;

public class ShoppingCart {
    
    private List<Cart> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addToCart(Cart cart4) {
        items.add(cart4);
    }

    public List<Cart> getItems() {
        return items;
    }
    
    
     public void displayCart() {
              System.out.println("\nItems in your cart:");
        for (Cart item : items) {
            System.out.println(item);
        }
    }
     
     public double calculateTotalPrice() {
        double total = 0.0;
        for (Cart item : items) {
            total += item.getprodPrice() * item.getprodqty();
        }
        return total;
    }


    
    
}
