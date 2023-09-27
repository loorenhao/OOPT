/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
class FileHandle {

    public static final String STAFF_FILE = "src/data1/staff.txt";
    public static final String MEMBER_FILE = "src/data1/member.txt";
    public static final String PRODUCT_FILE = "src/data1/product.txt";
    private static final Scanner sc = new Scanner(System.in);

    public static void checkFile() throws IOException {
        File fileS = new File(PRODUCT_FILE);

        if (!fileS.exists()) {
            //to add new content
            FileWriter myWriter = new FileWriter(PRODUCT_FILE, true);
            //line by line content
            try {
                myWriter.write("P1001|Marker Pen            |stationery|12|8.12|6.82\n");
                myWriter.write("P1002|Topvalu A4            |stationery|21|11.9|10.9\n");
                myWriter.write("P1003|Management File       |stationery|4|2.5|2.0\n");
                myWriter.write("P1004|Artist Brush          |stationery|23|8.9|6.22\n");
                myWriter.write("P1005|Glitter Glue          |stationery|15|17.9|15.0\n");
                myWriter.write("P1006|Football              |  sport   |24|81.16|61.22\n");
                myWriter.write("P1007|Basketball            |  sport   |30|45.23|40.0\n");
                myWriter.write("P1008|Badminton Racquet     |  sport   |4|210.64|190.0\n");
                myWriter.write("P1009|Baseball              |  sport   |8|98.23|90.0\n");
                myWriter.write("P1010|Nike Shoes            |  sport   |14|108.97|100.82\n");
                myWriter.write("P1011|Dining Table          |furniture |19|8.12|6.82\n");
                myWriter.write("P1012|Sofa Bed              |furniture |3|290.64|250.0\n");
                myWriter.write("P1013|Wood Chair            |furniture |12|49.99|39.82\n");
                myWriter.write("P1014|Wood Table            |furniture |9|85.68|76.15\n");
                myWriter.write("P1015|Curtain               |furniture |5|42.32|36.0\n");
                myWriter.write("P1016|Gardenia              |  food    |19|2.11|1.99\n");
                myWriter.write("P1017|Massimo               |  food    |32|2.4|2.0\n");
                myWriter.write("P1018|Cheese Bread          |  food    |45|3.99|3.0\n");
                myWriter.write("P1019|Sushi Onigiri         |  food    |23|4.99|4.98\n");
                myWriter.write("P1020|Chocolate Croissant   |  food    |14|2.33|2.1\n");
                myWriter.write("P1021|Panasonic Blender     | kitchen  |13|95.0|79.0\n");
                myWriter.write("P1022|Pensonic Rice Cooker  | kitchen  |2|79.0|69.0\n");
                myWriter.write("P1023|Khind Jug Kettle      | kitchen  |6|45.0|39.0\n");
                myWriter.write("P1024|Midea Induction Cooker| kitchen  |10|120.0|100.0\n");
                myWriter.write("P1025|Faber Air Fryer       | kitchen  |3|229.0|200.0\n");

                myWriter.close();
                System.out.println(PRODUCT_FILE + " does not exist.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(PRODUCT_FILE + " exists.");
        }
        // Create an ArrayList of strings
        ArrayList<String> FName = new ArrayList<>();

        // Add strings to the ArrayList
        FName.add(STAFF_FILE);
        FName.add(MEMBER_FILE);

        // Access and print the elements
        for (String filePath : FName) {
            File file = new File(filePath);

            if (file.exists()) {
                System.out.println(filePath + " exists.");
            } else {
                System.out.println(filePath + " does not exist.");
                file.createNewFile();
            }
        }

    }

    //write string to file
    public static void writeFile(String filename, String content) {
        try {
            File file = new File(filename);
            //check the present of the file
            if (!file.exists()) {
                //if no exist will auto create a file
                file.createNewFile();
            }

            //to add new content
            FileWriter myWriter;
            myWriter = new FileWriter(filename, true);
            //line by line content
            myWriter.write(content + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> readFileToList(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

}
