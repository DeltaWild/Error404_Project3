package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SearchGUI {

    // Components
    // ************************************************************* */
    // Frames & Panels
    private JFrame frame;
    private JPanel sRContainer;
    // Labels
    private JLabel searchLabel;
    private JLabel indexLabel;
    private JLabel indexCount;
    private JLabel emptyLabel;
    // TextFields & TextAreas
    static JTextField searchBox;
    public JTextArea searchReturn;
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

    public SearchGUI() {
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
        JLabel searchLabel = new JLabel("Search:", SwingConstants.RIGHT);
        //searchLabel.setBounds(25, 50, 100, 30);
        frame.add(searchLabel);

        JTextField searchBox = new JTextField(""); // search box
        //searchBox.setBounds(100, 50, 350, 30);
        frame.add(searchBox);

        // Main results field
        // ************************************************************* */
        // Create a container to hold results field
        JPanel sRContainer = new JPanel();
        //sRContainer.setBounds(25, 150, 550, 160); // set the container size and location
        frame.add(sRContainer);
        // Create a ScrollPane to hold the field
        JScrollPane scrollBar = new JScrollPane();
        //scrollBar.setPreferredSize(new Dimension(550, 156)); // set ScrollPane size
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sRContainer.add(scrollBar);
        // Create search return field
        JTextArea searchReturn = new JTextArea(""); // return text box
        searchReturn.setEditable(false);
        searchReturn.setOpaque(true);
        scrollBar.setViewportView(searchReturn); // set searchReturn to display in ScrollPane
        
        // Indexed files labels
        // ************************************************************* */
        JLabel indexLabel = new JLabel("Indexed Files: ", SwingConstants.LEFT);
        //indexLabel.setBounds(250, 350, 80, 30);
        frame.add(indexLabel);

        JLabel indexCount = new JLabel("0"); // indexed file return text
        //indexCount.setBounds(330, 350, 100, 30);
        frame.add(indexCount);

        // Radio buttons
        // ************************************************************* */
        JRadioButton allTermButton = new JRadioButton("All Terms");
       // allTermButton.setBounds(112, 100, 100, 50);
        frame.add(allTermButton);
        allTermButton.setSelected(true); // Set default selection
        allTermButton.addActionListener(e -> {
            try {
                new searchType(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        JRadioButton anyTermButton = new JRadioButton("Any Terms");
        //anyTermButton.setBounds(274, 100, 100, 50);
        frame.add(anyTermButton);
        anyTermButton.addActionListener(e -> {
            try {
                new searchType(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        JRadioButton exactTermButton = new JRadioButton("Exact Term");
        //exactTermButton.setBounds(436, 100, 100, 50);
        frame.add(exactTermButton);
        exactTermButton.addActionListener(e -> {
            try {
                new searchType(); // currently stub method
            }
            catch (UnsupportedOperationException Exception) {
                JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        ButtonGroup buttons = new ButtonGroup();
        buttons.add(allTermButton);
        buttons.add(anyTermButton);
        buttons.add(exactTermButton);

        // About button
        // ************************************************************* */
        JButton aboutButton = new JButton("About"); // About button
        //aboutButton.setBounds(450, 350, 125, 30);
        frame.add(aboutButton);
        aboutButton.addActionListener(e -> AboutGUI.aboutGui());

        // Maintenance button
        // ************************************************************* */
        JButton maintButton = new JButton("Maintenance"); // Maintenance button
        //maintButton.setBounds(25, 350, 125, 30);
        frame.add(maintButton);
        maintButton.addActionListener(e -> MaintenanceGUI.maintenanceGui());

        // Search button
        // ************************************************************* */
        JButton searchButton = new JButton("Search"); // Search Button
       // searchButton.setBounds(475, 50, 100, 30);
        frame.add(searchButton);
        searchButton.addActionListener(e -> {
                    String searchBoxText = searchBox.getText();
                    testMethod testing = new testMethod(searchBoxText);
                    searchReturn.setText(String.valueOf((testMethod.result)));
                });

        frame.addComponentListener(new ComponentAdapter() {// Let the window respond to the size change event
            @Override
            public void componentResized(ComponentEvent e) {
                double fraWidth = frame.getWidth();// Get the panel width
                double fraHeight = frame.getHeight();// Get the panel height

                indexLabel.setBounds((int) Math.round(((fraWidth)*0.5)-90.0),(int) Math.round((fraHeight-100)),80,30);
                indexCount.setBounds((int) Math.round(((fraWidth)*0.5)-10),(int) Math.round((fraHeight-100.0)),100,30);

                allTermButton.setBounds((int) Math.round((fraWidth*0.5)-175),100,100,50);
                anyTermButton.setBounds((int) Math.round((fraWidth*0.5)-50),100,100,50);
                exactTermButton.setBounds((int) Math.round((fraWidth*0.5)+75),100,100,50);



                maintButton.setBounds(25,(int) Math.round((fraHeight-100.0)),125,30);
                aboutButton.setBounds((int) Math.round(((fraWidth-175))),(int) Math.round((fraHeight-100.0)),125,30);




               // sRContainer.setBounds(25,150, (int) Math.round((fraWidth-25.0)),(int) Math.round(fraHeight-80.0));
               // scrollBar.setPreferredSize(new Dimension((int) Math.round((fraWidth/650.0)*550),(int) Math.round((fraHeight/450)*156))); // set ScrollPane size




                searchLabel.setBounds(25,50,100,30);
                searchBox.setBounds((150),50,(int) Math.round((fraWidth-325.0)),30);//(int) Math.round(((fraWidth/650.0)*550.0)-2*(fraWidth/650.0)*100),30);
                searchButton.setBounds((int) Math.round((fraWidth-150)),50,100,30);






            }
        });

        // Empty label to set window dimensions?
        // ************************************************************* */
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(650, 450)); // Sets main search window size
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        // Display the window.
        // ************************************************************* */
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(650, 450));
        //frame.setSize(650, 450);
        frame.setLocationRelativeTo(null);

    }
}
