/*
Creates and displays the scrollable table in the maintenance window.
*/

package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class maintDisplayTable extends JPanel {

    // Components
    // ************************************************************* */
    static JTable maintDisplayTable;
    private JScrollPane scrollPane;

    public maintDisplayTable() {
        super(new GridLayout(1,0));

        // Create a ScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(550, 196)); // set ScrollPane size
        add(scrollPane);

        // Create table
        JTable maintDisplayTable = new JTable(new tableContentsTest());
        maintDisplayTable.setFillsViewportHeight(true); // use entire container
        maintDisplayTable.setOpaque(true);
        scrollPane.setViewportView(maintDisplayTable); // set maintDisplayTable to display in ScrollPane

    }
}
