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
    // Table
    static JTable maintDisplayTable = new JTable(new fileList()); // Create table to hold file data
    // Scrollpane
    private JScrollPane scrollPane = new JScrollPane(); // Create scrollPane to make table scrollable
    // Labels
    JLabel maintTitleLabel = new JLabel(); // Title
    JLabel maintIndexLabel = new JLabel(); // Index file count
    static JLabel maintIndexCount = new JLabel(); // Index file count
    // Buttons
    JButton maintAddFile = new JButton(); // Add file button
    JButton maintRebuild = new JButton(); // Rebuild index button
    JButton maintRemoveFile = new JButton(); // Remove file button
    // ImageIcon
    final ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png");
    // Layout
    GridBagConstraints gridConstraints = new GridBagConstraints(); // Layout management
    // Screen size variables
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Get size of user's screen
    static int screenWidth = screenSize.width;
    static int screenHeight = screenSize.height;
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
        frame.add(scrollPane, gridConstraints);
        scrollPane.setPreferredSize(new Dimension((int)(MaintenanceGUI.screenWidth * 0.4),
                (int)(MaintenanceGUI.screenHeight * 0.4))); // Set size of scrollPane to 40% of user's screen

        // Create table
        maintDisplayTable.setRowSelectionAllowed(true); // Allow user to select a row
        maintDisplayTable.setColumnSelectionAllowed(false); // Do not allow user to select a column
        maintDisplayTable.setSelectionMode(0); // Single file selection only
        maintDisplayTable.setFillsViewportHeight(true); // use entire container
        maintDisplayTable.setAutoResizeMode(4); // Resize all columns
        scrollPane.setViewportView(maintDisplayTable); // set maintDisplayTable to display in ScrollPane
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
                new fileList().AddFile();
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
        window.revalidate();
        window.pack();
        window.repaint();
        window.setVisible(true);
        //window.setMinimumSize(new Dimension(650, 450));
        window.setLocationRelativeTo(null);
        /* ***** */
    }
}
