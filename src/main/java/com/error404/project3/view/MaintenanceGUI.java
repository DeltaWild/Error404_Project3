package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class MaintenanceGUI {
    static void maintenanceGui() {
        // Create and set up the window.
        // ************************************************************* */
        JFrame frame = new JFrame("Maintenance");

        // Set application icon
        // ************************************************************* */
        ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png");
        frame.setIconImage(error404Icon.getImage());

        JTextArea maintTextArea = new JTextArea(); // Maintenance return text area
        maintTextArea.setBounds(25, 75, 550, 200);
        // jScrollPane1.setViewportView(maintTextArea);
        frame.add(maintTextArea);

        // Add file button
        // ************************************************************* */
        JButton maintAddFile = new JButton("Add File"); // Add File button
        maintAddFile.setBounds(37, 300, 150, 30);
        frame.add(maintAddFile);
        maintAddFile.addActionListener(e -> maintTextArea.setText("404 (Not Found)"));

        // Rebuild index button
        // ************************************************************* */
        JButton maintRebuild = new JButton("Rebuild Out of Date"); // Rebuild button
        maintRebuild.setBounds(224, 300, 150, 30);
        frame.add(maintRebuild);
        maintRebuild.addActionListener(e -> maintTextArea.setText("401 (Unauthorized)"));

        // Remove file button
        // ************************************************************* */
        JButton maintRemoveFile = new JButton("Remove File"); // Remove File button
        maintRemoveFile.setBounds(411, 300, 150, 30);
        frame.add(maintRemoveFile);
        maintRemoveFile.addActionListener(e -> maintTextArea.setText("403 (Forbidden)"));

        // Title label
        // ************************************************************* */
        JLabel maintLabel1 = new JLabel("Search Engine - Index Maintenance"); // Title
        maintLabel1.setBounds(125, 25, 350, 30);
        frame.add(maintLabel1);
        maintLabel1.setFont(maintLabel1.getFont().deriveFont(20.0f));

        // Indexed files labels
        // ************************************************************* */
        JLabel maintIndexLabel = new JLabel("Indexed Files: "); // Index file count
        maintIndexLabel.setBounds(250, 350, 80, 30);
        frame.add(maintIndexLabel);

        JLabel maintIndexCount = new JLabel("0"); // Index file count
        maintIndexCount.setBounds(330, 350, 100, 30);
        frame.add(maintIndexCount);

        // Empty label to set window dimensions?
        // ************************************************************* */
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(600, 400)); // sets window size
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        // Display the window.
        // ************************************************************* */
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
