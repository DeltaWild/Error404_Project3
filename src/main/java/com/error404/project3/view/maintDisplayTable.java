/*
Creates and displays the scrollable table in the maintenance window.
*/

package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class maintDisplayTable extends JPanel {

    // Components
    /* ***** */
    // Table
    static JTable maintDisplayTable = new JTable(new fileList());
    // Scrollpane
    private JScrollPane scrollPane = new JScrollPane();
    /* ***** */

    public maintDisplayTable() {
        // Set GridLayout
        super(new GridLayout(1,0));

        // Create a ScrollPane to hold the table
        add(scrollPane);

        // Create table
        maintDisplayTable.setFillsViewportHeight(true); // use entire container
        maintDisplayTable.setOpaque(true);
        scrollPane.setViewportView(maintDisplayTable); // set maintDisplayTable to display in ScrollPane

    }
}
