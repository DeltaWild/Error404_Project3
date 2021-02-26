package com.error404.project3.view;

import javax.swing.*;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class AddFile {

    // Frame

    static JFrame fileChooser;

    public static void addFile() throws IOException {


            // Add file popup window
            JFrame fileChooser = new JFrame("JFileChooser Popup");
            JLabel directoryLabel = new JLabel();
            fileChooser.add(directoryLabel);
            JLabel fileNameLabel = new JLabel();
            fileChooser.add(fileNameLabel);
            JFileChooser addFile = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text Files", "txt");
            addFile.setFileFilter(filter);
            fileChooser.add(addFile);
            fileChooser.pack();
            fileChooser.setVisible(true);

            addFile.addActionListener(e -> {
                try {
                    JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                catch (UnsupportedOperationException Exception) {
                    JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            });



        }
    }