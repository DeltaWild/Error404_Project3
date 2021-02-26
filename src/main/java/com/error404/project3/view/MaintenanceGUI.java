package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MaintenanceGUI {

    // Components
    // ************************************************************* */
    // Frame
    static JFrame frame;
    static JFrame fileChooser;
    // Labels
    private JLabel maintTitleLabel;
    private JLabel maintIndexLabel;
    private JLabel maintIndexCount;
    private JLabel emptyLabel;
    // Buttons
    static JButton maintAddFile;
    private JButton maintRebuild;
    private JButton maintRemoveFile;
    private JFileChooser addFile;
    // JPanel
    private JPanel mDTContainer;
    // ImageIcon
    private ImageIcon error404Icon;


    public static void maintenanceGui() {
        // Create and set up the window.
        // ************************************************************* */
        JFrame frame = new JFrame("Maintenance");

        // Set application icon
        // ************************************************************* */
        ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png");
        frame.setIconImage(error404Icon.getImage());

        // Main display area
        // ************************************************************* */
        // Create a container to hold table
        JPanel mDTContainer = new JPanel();
        mDTContainer.setBounds(25, 75, 550, 200); // Set the container size and location
        frame.add(mDTContainer);
        // Add display table to the container
        maintDisplayTable mDT = new maintDisplayTable();
        mDTContainer.add(mDT);

        // Add file button
        // ************************************************************* */
        JButton maintAddFile = new JButton("Add File"); // Add File button
        maintAddFile.setBounds(37, 300, 150, 30);
        frame.add(maintAddFile);
        maintAddFile.addActionListener(e -> {
            try {
                AddFile.addFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });





        // Rebuild index button
        // ************************************************************* */
        JButton maintRebuild = new JButton("Rebuild Out of Date"); // Rebuild button
        maintRebuild.setBounds(224, 300, 150, 30);
        frame.add(maintRebuild);
        maintRebuild.addActionListener(e -> {
            try {
                new indexMaint(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Remove file button
        // ************************************************************* */
        JButton maintRemoveFile = new JButton("Remove File"); // Remove File button
        maintRemoveFile.setBounds(411, 300, 150, 30);
        frame.add(maintRemoveFile);
        maintRemoveFile.addActionListener(e -> {
            try {
                new indexMaint(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Title label
        // ************************************************************* */
        JLabel maintTitleLabel = new JLabel("Search Engine - Index Maintenance"); // Title
        maintTitleLabel.setBounds(125, 25, 350, 30);
        frame.add(maintTitleLabel);
        maintTitleLabel.setFont(maintTitleLabel.getFont().deriveFont(20.0f));

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

    static JButton getMaintAddFile() {
        return maintAddFile;
    }

    static void setMaintAddFile(JButton maintAddFile) {
        MaintenanceGUI.maintAddFile = maintAddFile;
    }
}
