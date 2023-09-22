/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

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
}
