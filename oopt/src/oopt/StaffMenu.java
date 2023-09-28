/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

/**
 *
 * @author User
 */
public class StaffMenu {

    
    public static void staffMenu() {
         int staffMenuSelect;
        do {
            System.out.printf("\nMain Menu\n1. Staff Details\n2. Customer Details\n3. Product Menu\n4. Modify Product\n5. Log out\n\nEnter your choice > ");
            staffMenuSelect = Validation.getIntInput();
            switch (staffMenuSelect) {
                case 1 -> {Staff.displayStaffDetails();
                }
                case 2 -> {Member.displayMemberDetails();
                }
                case 3 -> {StaffProductMenu();
                }
                case 4 -> {Product.ModifyProduct(); 
                }
                case 5 -> FIrstMenu.menu1();
                default -> System.out.println("\nInvalid Input! Pls enter 1~5!");
            }
                    } while (true);
    }
    
       private static void StaffProductMenu() {
        int choice;
        do {
            System.out.printf(" \nProduct Menu \n1. Display All Product\n2. Search Product\n3. Exit\nEnter your choice > ");
            choice = Validation.getIntInput();

            switch (choice) {
                case 1 -> {Product.staffDisplayAllProduct();
                }
                case 2 -> {Product.staffSearchProductModule();
                }
                case 3 -> {return;  
                }
                default -> {System.out.println("\nInvalid Input! Pls enter 1~3!");
                }
            }
        } while (true);

    }
}
