/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba1;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author Potapov-VI
 */
public class Laba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Brez");
        window.setSize(600, 400);
        window.setContentPane(new BresenhamLine());
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    
    }
    
}
