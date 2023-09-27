/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author USER
 */
class Formater {

    public static void clearScreen() {
        {
            try {
                Robot rb = new Robot();
                rb.keyPress(KeyEvent.VK_CONTROL);
                rb.keyPress(KeyEvent.VK_L);
                rb.keyRelease(KeyEvent.VK_L);
                rb.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(5200);
                System.out.println("Do you want to:");
            } catch (AWTException | InterruptedException ex) {

            }
        }
    }
}