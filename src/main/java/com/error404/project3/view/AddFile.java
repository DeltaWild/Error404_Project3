package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class AddFile {

    // Frame

    static JFrame fileChooser;

    public static void addFile() {


        // Add file popup window
        JFrame fileChooser = new JFrame("JFileChooser Popup");
        JLabel directoryLabel = new JLabel();
        fileChooser.add(directoryLabel);
        JLabel fileNameLabel = new JLabel();
        fileChooser.add(fileNameLabel);
        JFileChooser addFile = new JFileChooser();
        fileChooser.add(addFile);
        fileChooser.pack();
        fileChooser.setVisible(true);

        addFile.addActionListener(e -> {
            try {
                new indexMaint(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });



    }
}