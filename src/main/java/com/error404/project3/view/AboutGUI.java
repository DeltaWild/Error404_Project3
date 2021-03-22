/*
Creates a simple window containing information about the program.
*/

package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class AboutGUI {

    // Components
    /* ***** */
    // Frames & Panels
    JFrame window = new JFrame(); // Create window
    JPanel frameAbout = new JPanel(); // Create frame for contents to go in
    // Label
    JLabel aboutLabel = new JLabel(); // Label that holds main HTML markup text
    // ImageIcon
    ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png"); // Set application icon
    // Layout
    GridBagConstraints gridConstraints = new GridBagConstraints(); // Layout management
    /* ***** */

    public AboutGUI() {

        // Set up frame
        /* ***** */
        window.setTitle("About");
        window.setIconImage(error404Icon.getImage()); // Set custom application icon
        window.add(frameAbout);
        frameAbout.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        frameAbout.setLayout(new GridBagLayout());
        /* ***** */

        // Display about information
        /* ***** */
        aboutLabel.setText(
                "<html><body><div style=\"color: black; font-weight: bold; font-size: 14pt;" +
                        "\">Developers:</div><div style=\"color: black; font-weight: normal; font-size: 12pt;" +
                        "\">Lauren Bartlett<br />Sean Brown<br />Brianna MacKenzie<br /><br /></div><div " +
                        "style=\"color: black; font-weight: bold; font-size: 14pt;\">Group Name:</div><div " +
                        "style=\"color: black; font-weight: normal; font-size: 12pt;\">Error404<br /><br /></div><div" +
                        " style=\"color: black; font-weight: bold; font-size: 14pt;\">Repositories:</div><div " +
                        "style=\"color: black; font-weight: normal; font-size: 12pt; padding-bottom: 15px;" +
                        "\">https://github.com/DeltaWild/Error404_Project3</div></html>");
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        frameAbout.add(aboutLabel, gridConstraints);
        /* ***** */

        // Display the window.
        /* ***** */
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        /* ***** */
    }
}
