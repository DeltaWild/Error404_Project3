/*
Creates the index maintenance window.
*/

package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class MaintenanceGUI {

    // Components
    /* ***** */
    // Frame & Panel
    JFrame window = new JFrame(); // Create window
    JPanel frame = new JPanel(); // Create frame for contents to go in
    JPanel mDTContainer = new JPanel(); // Container to hold results table
    // Table
    maintDisplayTable mDT = new maintDisplayTable(); // Results table
    // Labels
    JLabel maintTitleLabel = new JLabel(); // Title
    JLabel maintIndexLabel = new JLabel(); // Index file count
    static JLabel maintIndexCount = new JLabel(); // Index file count
    JLabel emptyLabel;
    // Buttons
    JButton maintAddFile = new JButton(); // Add file button
    JButton maintRebuild = new JButton(); // Rebuild index button
    JButton maintRemoveFile = new JButton(); // Remove file button
    JFileChooser addFile;
    // ImageIcon
    final ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png");
    // Layout
    GridBagConstraints gridConstraints = new GridBagConstraints(); // Layout management
    /* ***** */


    public MaintenanceGUI() {

        // Set up frame
        /* ***** */
        window.setTitle("Maintenance"); // Window title
        window.setIconImage(error404Icon.getImage()); // Window icon
        window.add(frame);
        frame.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        frame.setLayout(new GridBagLayout());
        /* ***** */

        // Title label
        /* ***** */
        maintTitleLabel.setText("Search Engine - Index Maintenance");
        maintTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maintTitleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0; // Grid position 0,0
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 1.0; // Give horizontal spacing preference to this first
        gridConstraints.weighty = 0.0; // Give no vertical spacing preference to this
        gridConstraints.gridwidth = 3; // Grid cell is 3 wide
        frame.add(maintTitleLabel, gridConstraints);
        /* ***** */

        // Main display area
        /* ***** */
        // Container to hold table
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.gridx = 0; // Grid position 0,1
        gridConstraints.gridy = 1;
        gridConstraints.weightx = 1.0; // Give horizontal spacing preference to this first
        gridConstraints.weighty = 1.0; // Give vertical spacing preference to this first
        gridConstraints.gridwidth = 3; // Grid cell is 3 wide
        frame.add(mDTContainer, gridConstraints);

        mDTContainer.add(mDT); // Add display table to the container
        /* ***** */

        // Indexed files labels
        /* ***** */
        maintIndexLabel.setText("Indexed Files: ");
        maintIndexLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 0; // Grid position 0,2
        gridConstraints.gridy = 2;
        gridConstraints.weightx = 0.0; // Give horizontal spacing preference to this first
        gridConstraints.weighty = 0.0; // Reset vertical spacing
        gridConstraints.gridwidth = 1; // Grid cell is 1 wide
        frame.add(maintIndexLabel, gridConstraints);

        maintIndexCount.setText("0");
        maintIndexLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 1; // Grid position 1,2
        gridConstraints.gridy = 2;
        gridConstraints.weightx = 0.0; // Give horizontal spacing preference to this first
        gridConstraints.gridwidth = 2; // Grid cell is 1 wide
        frame.add(maintIndexCount, gridConstraints);
        /* ***** */

        // Buttons
        /* ***** */
        // Add file button
        maintAddFile.setText("Add File");
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 0; // Grid position 0,3
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.3; // Give horizontal spacing preference to this first
        gridConstraints.gridwidth = 1; // Grid cell is 1 wide
        frame.add(maintAddFile, gridConstraints);
        maintAddFile.addActionListener(e -> {
            try {
                new AddFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        // Rebuild index button
        maintRebuild.setText("Rebuild Out of Date");
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 1; // Grid position 1,3
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.3; // Give horizontal spacing preference to this first
        gridConstraints.gridwidth = 1; // Grid cell is 1 wide
        frame.add(maintRebuild, gridConstraints);
        maintRebuild.addActionListener(e -> {
            try {
                new indexMaint(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Remove file button
        maintRemoveFile.setText("Remove File");
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 2; // Grid position 2,3
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.3; // Give horizontal spacing preference to this first
        gridConstraints.gridwidth = 1; // Grid cell is 1 wide
        frame.add(maintRemoveFile, gridConstraints);
        maintRemoveFile.addActionListener(e -> {
            try {
                new indexMaint(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        /* ***** */

        // Display the window.
        /* ***** */
        window.pack();
        window.setVisible(true);
        window.setMinimumSize(new Dimension(650, 450));
        window.setLocationRelativeTo(null);
        /* ***** */
    }
}
