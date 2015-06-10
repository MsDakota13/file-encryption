/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hro.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author cyvan
 */
public class GUI {
    public void start() {
        //Create and set up the window.
        JFrame frame = new JFrame("Filecrypter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add content to the window.
        frame.add(new Frame());

        //Display the window.
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
