/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class Validation {
    
    public static boolean CheckMinMax(int input, int min, int max){
        if (input>max||input<min){
            System.out.println("Please Enter Number Within range "+ min +" - "+ max +"\n");
            return false;
        }
        else return true;
    }
    
    public static boolean checkProductID(String inputProdID){
          String CusProductFile = "src/data1/product.txt"; // Replace with file path
        try (BufferedReader br = new BufferedReader(new FileReader(CusProductFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6 && parts[0].equals(inputProdID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return false;
    }
    
    public static boolean checkQuantity(String inputProdID,int inputProdQty){
        String CusProductFile = "src/data1/product.txt"; 
        try (BufferedReader br = new BufferedReader(new FileReader(CusProductFile))) {
            String line;
             while ((line = br.readLine()) != null) {
              String[] parts = line.split("\\|");
                  if (parts.length == 6 && parts[0].equals(inputProdID)) {
                      int availableQuantity = Integer.parseInt(parts[3].trim()); // Parse the available quantity from the file
                  if (availableQuantity >= inputProdQty && availableQuantity > 0) {
                    return true; //enough stocks
                } else {
                    return false; //Not enough stocks
                }
            }
                  
             }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
        return false; // An error occurred while reading the file
    }
        return false;
    }
    
}
