package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceGUI {
    static void maintenanceGui() {
        // Create and set up the window.
        JFrame frame = new JFrame("Maintenance");

        JTextArea maintTextArea = new JTextArea(); // Maintenance return text area
        maintTextArea.setBounds(25, 75, 550, 200);
        // jScrollPane1.setViewportView(maintTextArea);
        frame.add(maintTextArea);

        // *********************************************************** */
        JButton maintAddFile = new JButton("Add File"); // Add File button
        maintAddFile.setBounds(37, 300, 150, 30);
        frame.add(maintAddFile);

        maintAddFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                maintTextArea.setText("404 (Not Found)");
            }
        });
        // *************************************************************** */
        JButton maintRebuild = new JButton("Rebuild Out of Date"); // Rebuild button
        maintRebuild.setBounds(224, 300, 150, 30);
        frame.add(maintRebuild);

        maintRebuild.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                maintTextArea.setText("401 (Unauthorized)");
            }
        });
        // *************************************************************** */
        JButton maintRemoveFile = new JButton("Remove File"); // Remove File button
        maintRemoveFile.setBounds(411, 300, 150, 30);
        frame.add(maintRemoveFile);

        maintRemoveFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                maintTextArea.setText("403 (Forbidden)");
            }
        });
        // *************************************************************** */

        JLabel maintLabel1 = new JLabel("Search Engine - Index Maintenance"); // Title
        maintLabel1.setBounds(125, 25, 350, 30);
        frame.add(maintLabel1);
        maintLabel1.setFont(maintLabel1.getFont().deriveFont(20.0f));

        JLabel maintLabel2 = new JLabel("Indexed Files: 0"); // Index file count
        maintLabel2.setBounds(250, 350, 100, 30);
        frame.add(maintLabel2);
        // *********************************************************** */

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(600, 400)); // sets window size
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
