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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author USER
 */
public class Inventory {


    private static final String PRODUCT_FILE = "src/product.txt";
    private final List<Product> products;
    private final Map<String, List<Product>> productsByCategory;

    
    public Inventory(){
        products = new ArrayList<>();
        productsByCategory = new HashMap<>();
    }
    
    public void readProductsFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String productID = data[0];
                String productName = data[1];
                String catgory = data[2];
                int prodQty = Integer.parseInt(data[3]);               
                double price = Double.parseDouble(data[4]);
                double grossPrice = Double.parseDouble(data[5]);

                Product product = new Product(productName, catgory, prodQty, price,grossPrice,productID);
                products.add(product);
                productsByCategory.putIfAbsent(catgory, new ArrayList<>());
                productsByCategory.get(catgory).add(product);
            }
        }
        catch(IOException e){
            System.out.println("Error occured when reading products file");
        }
    }
    

    
    public List<Product> getProductList(String category){
        return productsByCategory.get(category);
    }
    
    public Set<String> getCategory(){
        return productsByCategory.keySet();
    }
    
    public Product getProduct(String productID){
        for(Product product : products){
            if(productID.equals(product.getprodID())){
                return product;
            }
        }
        //productID not present
        return null;
    }



    

}


