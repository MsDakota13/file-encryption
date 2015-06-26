/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hro.gui;

import com.hro.encryper.crypters.AesCrypter;
import com.hro.encrypter.*;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author cyvan
 */
public class Frame extends JPanel implements ActionListener{
    static private final String newline = "\n";
    static private String source_file, destination_file;
    JCheckBox aes = new JCheckBox("aes");
    JCheckBox sha1 = new JCheckBox("sha1");
    JCheckBox sha2 = new JCheckBox("sha2");
    JButton source, destination, encrypt, decrypt;
    JTextArea log;
    JFileChooser fc;
    public String key = "Mary has one cat";
    

    public Frame() {
        super(new BorderLayout());

        //Create the log
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Create the open button
        source = new JButton("Select Source file");
        source.addActionListener(this);

        //Create the save button.
        destination = new JButton("Select destination file");
        destination.addActionListener(this);
        
        encrypt = new JButton("Encrypt");
        encrypt.addActionListener(this);
        
        decrypt = new JButton("decrypt");
        decrypt.addActionListener(this);
        
        //Put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(source);
        buttonPanel.add(destination);
        buttonPanel.add(encrypt);
        buttonPanel.add(decrypt);
        
        JPanel methods = new JPanel();
        aes.setSelected(true);
        sha1.setSelected(true);
        sha2.setSelected(true);
        methods.add(aes);
        methods.add(sha1);
        methods.add(sha2);
        
        //Add the buttons and the log to this panel.
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(buttonPanel, BorderLayout.PAGE_START);
        top.add(methods, BorderLayout.CENTER);
        
        add(top, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == source) {
            int returnVal = fc.showOpenDialog(Frame.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //Set the source file
                source_file = file.getPath();
                log.append("Source file set to: " + file.getPath() + "." + newline);
            } else {
                log.append("Getting source file canceled by user" + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

        //Handle destination button action.
        } else if (e.getSource() == destination) {
            int returnVal = fc.showSaveDialog(Frame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //Set the destination directory
                destination_file = file.getPath();
                log.append("Destination file set to: " + file.getPath() + "." + newline);
            } else {
                log.append("Setting destination file canceled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        } else if (e.getSource() == encrypt || e.getSource() == decrypt) {
                if(source_file==null || destination_file==null){
                	log.append("You need to set the source and destination file befor you can start collecting data!" + newline);
                }
                else if(!aes.isSelected()&&!sha1.isSelected()&&!sha2.isSelected()){
                    log.append("You need to select at least one encryption to gather info about" + newline);
                }
                else{
                    encrypt.setEnabled(false);
                    decrypt.setEnabled(false);
                    source.setEnabled(false);
                    destination.setEnabled(false);
                    String filename=destination_file.substring(destination_file.lastIndexOf("\\") + 1);
                    String[] dir=destination_file.split(filename);
                    if(e.getSource() == encrypt){
                        log.append(new CryptoHandler().encrypt("AES", key, new File(dir[0]+filename), new File(dir[0]+filename+".encrypted")) + newline);
                        encrypt.setEnabled(true);
                        decrypt.setEnabled(true);
                        source.setEnabled(true);
                        destination.setEnabled(true);
                    } else if (e.getSource() == decrypt){
                        log.append(new CryptoHandler().decrypt("AES", key, new File(dir[0]+filename), new File(dir[0]+filename+".decrypted")) + newline);
                        encrypt.setEnabled(true);
                        decrypt.setEnabled(true);
                        source.setEnabled(true);
                        destination.setEnabled(true);
                    }
                }
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
}

