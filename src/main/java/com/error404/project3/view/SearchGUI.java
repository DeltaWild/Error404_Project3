package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class SearchGUI {

    // Components
    // ************************************************************* */
    // Labels
    private JLabel searchLabel;
    private JLabel indexLabel;
    private JLabel indexCount;
    private JLabel emptyLabel;
    // TextFields & TextAreas
    static JTextField searchBox;
    static JTextArea searchReturn;
    // Radio buttons
    private JRadioButton allTermButton;
    private JRadioButton anyTermButton;
    private JRadioButton exactTermButton;
    private ButtonGroup buttons;
    // Buttons
    private JButton aboutButton;
    private JButton maintButton;
    private JButton searchButton;
    // ImageIcon
    private ImageIcon error404Icon;

    static void searchGui() {
        // Create and set up main window.
        // ************************************************************* */
        JFrame frame = new JFrame("Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set application icon
        // ************************************************************* */
        ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png");
        frame.setIconImage(error404Icon.getImage());

        // Search label and text field
        // ************************************************************* */
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(25, 50, 100, 30);
        frame.add(searchLabel);

        JTextField searchBox = new JTextField(""); // search box
        searchBox.setBounds(100, 50, 350, 30);
        frame.add(searchBox);

        // Main results field (this needs to be scrollable)
        // ************************************************************* */
        
        JPanel panel = new JPanel();
        JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollBar);
        scrollBar.setBounds(25, 150, 550, 150);
        JTextArea searchReturn = new JTextArea(); // return text box
        //searchReturn.setBounds(25, 150, 550, 150);
        searchReturn.setEditable(false);
        panel.add(searchReturn);
        
        /*        
        JTextArea searchReturn = new JTextArea(); // return text box
        searchReturn.setBounds(25, 150, 550, 150);
        searchReturn.setEditable(false);
        frame.add(searchReturn);
        */
        
        // Indexed files labels
        // ************************************************************* */
        JLabel indexLabel = new JLabel("Indexed Files: ");
        indexLabel.setBounds(250, 350, 80, 30);
        frame.add(indexLabel);

        JLabel indexCount = new JLabel("0"); // indexed file return text
        indexCount.setBounds(330, 350, 100, 30);
        frame.add(indexCount);

        // Radio buttons
        // ************************************************************* */
        JRadioButton allTermButton = new JRadioButton("All Terms");
        allTermButton.setBounds(112, 100, 100, 50);
        frame.add(allTermButton);
        allTermButton.setSelected(true); // Set default selection

        JRadioButton anyTermButton = new JRadioButton("Any Terms");
        anyTermButton.setBounds(274, 100, 100, 50);
        frame.add(anyTermButton);

        JRadioButton exactTermButton = new JRadioButton("Exact Term");
        exactTermButton.setBounds(436, 100, 100, 50);
        frame.add(exactTermButton);

        ButtonGroup buttons = new ButtonGroup();
        buttons.add(allTermButton);
        buttons.add(anyTermButton);
        buttons.add(exactTermButton);

        // About button
        // ************************************************************* */
        JButton aboutButton = new JButton("About"); // About button
        aboutButton.setBounds(450, 350, 125, 30);
        frame.add(aboutButton);
        aboutButton.addActionListener(e -> AboutGUI.aboutGui());

        // Maintenance button
        // ************************************************************* */
        JButton maintButton = new JButton("Maintenance"); // Maintenance button
        maintButton.setBounds(25, 350, 125, 30);
        frame.add(maintButton);
        maintButton.addActionListener(e -> MaintenanceGUI.maintenanceGui());

        // Search button
        // ************************************************************* */
        JButton searchButton = new JButton("Search"); // Search Button
        searchButton.setBounds(475, 50, 100, 30);
        frame.add(searchButton);
        searchButton.addActionListener(e -> {
                    String searchBoxText = searchBox.getText();
                    testMethod.testMethod(searchBoxText);
                    searchReturn.setText(String.valueOf((testMethod.result)));
                });

        // Empty label to set window dimensions?
        // ************************************************************* */
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(600, 400)); // Sets main search window size
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        // Display the window.
        // ************************************************************* */
        frame.pack();
        frame.setVisible(true);
        frame.setSize(625, 450);
        frame.setLocationRelativeTo(null);
    }
}
