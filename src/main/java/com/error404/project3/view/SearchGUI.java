/*
Creates the main search window of the program.
*/

package com.error404.project3.view;

import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.*;

public class SearchGUI {

    // Components
    /* ***** */
    // Frames & Panels
    JFrame window = new JFrame(); // Create window
    JPanel frame = new JPanel(); // Create frame for contents to go in
    // Scrollbar
    JScrollPane scrollBar = new JScrollPane(); // Create scrollable results window
    // Labels
    JLabel searchLabel = new JLabel(); // Set label for the search field
    JLabel indexLabel = new JLabel(); // Index counter label
    static JLabel indexCount = new JLabel(); // Index counter number **THIS LABEL TO BE MODIFIED BY METHOD**
    JLabel emptyLabel = new JLabel(); // Empty label
    // TextFields & TextAreas
    static JTextField searchBox = new JTextField(""); // Search input field
    static JTextArea searchReturn = new JTextArea(); // Search output field
    // Radio buttons
    JRadioButton allTermButton = new JRadioButton(); // All radio button
    JRadioButton anyTermButton = new JRadioButton(); // Any radio button
    JRadioButton exactTermButton = new JRadioButton(); // Exact radio button
    ButtonGroup buttons = new ButtonGroup(); // Radio button group
    // Buttons
    JButton aboutButton = new JButton(); // About button
    JButton maintButton = new JButton(); // Maintenance button
    JButton searchButton = new JButton(); // Search Button
    // ImageIcon
    ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png"); // Set application icon
    // Layout
    GridBagConstraints gridConstraints = new GridBagConstraints(); // Layout management
    /* ***** */

    public SearchGUI() {

        // Set up frame
        /* ***** */
        window.setTitle("Search");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Proper close behavior
        window.setIconImage(error404Icon.getImage()); // Set custom application icon
        window.add(frame);
        frame.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        frame.setLayout(new GridBagLayout());
        /* ***** */

        // Set up search input
        /* ***** */
        // Searchbar text
        searchLabel.setText("Search:");
        searchLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0; // Grid position 0,0
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 0.5; // Give horizontal spacing preference to this second
        frame.add(searchLabel, gridConstraints);

        // Search input bar
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 1; // Grid position 1,0
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 1; // Give horizontal spacing preference to this first
        gridConstraints.gridwidth = 3; // Grid cell is 3 wide
        frame.add(searchBox, gridConstraints);

        // Search button
        searchButton.setText("Search");
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 4; // Grid position 4,0
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 0.0; // Give no horizontal spacing preference to this (do not resize with window)
        gridConstraints.gridwidth = 1; // Reset grid cell width to 1
        frame.add(searchButton, gridConstraints);
        searchButton.addActionListener(e -> {
            String searchBoxText = searchBox.getText();
            testMethod testing = new testMethod(searchBoxText);
            searchReturn.setText(String.valueOf((testMethod.result)));
        });

        // Placeholder
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 0.5; // Give horizontal spacing preference to this second
        frame.add(emptyLabel, gridConstraints);
        /* ***** */

        // Radio buttons
        /* ***** */
        // All terms
        allTermButton.setText("All Terms");
        allTermButton.setSelected(true); // Set default selection
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 1; // Grid position is 1,1
        gridConstraints.gridy = 1;
        gridConstraints.weightx = 0.0; // Give no horizontal spacing preference to this (do not resize with window)
        frame.add(allTermButton, gridConstraints);
        allTermButton.addActionListener(e -> {
            try {
                new searchType(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        // Any terms
        anyTermButton.setText("Any Terms");
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 2; // Grid position is 2,1
        gridConstraints.gridy = 1;
        gridConstraints.weightx = 0.0; // Give no horizontal spacing preference to this (do not resize with window)
        frame.add(anyTermButton, gridConstraints);
        anyTermButton.addActionListener(e -> {
            try {
                new searchType(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        // Exact term
        exactTermButton.setText("Exact Term");
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 3; // Grid position 3,1
        gridConstraints.gridy = 1;
        gridConstraints.weightx = 1; // Give horizontal spacing preference to this first
        frame.add(exactTermButton, gridConstraints);
        exactTermButton.addActionListener(e -> {
            try {
                new searchType(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Add to button group
        buttons.add(allTermButton);
        buttons.add(anyTermButton);
        buttons.add(exactTermButton);
        /* ***** */

        // Setting up the main results field
        /* ***** */
        // Scrollbar
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setViewportView(searchReturn); // set searchReturn to display in ScrollPane
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.gridx = 0; // Grid position 0,2
        gridConstraints.gridy = 2;
        gridConstraints.weightx = 1; // Give horizontal spacing preference to this first
        gridConstraints.weighty = 1; // Give vertical spacing preference to this first
        gridConstraints.gridwidth = 6; // Grid cell is 5 wide
        frame.add(scrollBar, gridConstraints);

        // Return field
        searchReturn.setOpaque(true);
        searchReturn.setEditable(false);
        searchReturn.setText("");
        /* ***** */

        // Maintenance/About buttons, indexed files
        /* ***** */
        // Maintenance button
        maintButton.setText("Maintenance");
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 0; // Grid position 0,3
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.5; // Give horizontal spacing preference to this second
        gridConstraints.weighty = 0.0; // Reset vertical spacing preference
        gridConstraints.gridwidth = 1; // Reset grid cell width to 1
        frame.add(maintButton, gridConstraints);
        maintButton.addActionListener(e -> new MaintenanceGUI());

        // Index descriptive text
        indexLabel.setText("Indexed Files: ");
        indexLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 1; // Grid position 1,3
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.0; // Give no horizontal spacing preference to this (do not resize with window)
        gridConstraints.gridwidth = 2; // Grid cell is 2 wide
        gridConstraints.insets = new Insets(0,10,0,0);
        frame.add(indexLabel, gridConstraints);
        // Index return text
        indexCount.setText("0");
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 3; // Grid position 2,3
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.0; // Give no horizontal spacing preference to this (do not resize with window)
        gridConstraints.gridwidth = 2; // Grid cell is 2 wide
        gridConstraints.insets = new Insets(0,0,0,0);
        frame.add(indexCount, gridConstraints);

        // About button
        aboutButton.setText("About");
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 3;
        gridConstraints.weightx = 0.5; // Give horizontal spacing preference to this second
        gridConstraints.gridwidth = 1; // Reset grid cell width to 1
        frame.add(aboutButton, gridConstraints);
        aboutButton.addActionListener(e -> new AboutGUI());
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
