package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class AboutGUI {
    static void aboutGui() {

        // Create and set up the window.
        JFrame frameAbout = new JFrame("About");

        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(400, 250));
        // Set contents of label
        label.setText(
                "<html><p><div style=\"color: black; font-weight: bold; font-size: 14pt;\">Developers:</div><div style=\"color: black; font-weight: normal; font-size: 12pt;\">Lauren Bartlett<br />Sean Brown<br />Brianna MacKenzie</div></p><p><div style=\"color: black; font-weight: bold; font-size: 14pt;\">Group Name:</div><div style=\"color: black; font-weight: normal; font-size: 12pt;\">Error404</div></p><p><div style=\"color: black; font-weight: bold; font-size: 14pt;\">Repositories:</div><div style=\"color: black; font-weight: normal; font-size: 12pt;\">https://github.com/DeltaWild/Error404_Project3</div></p></html>");

        // Set application icon
        // ************************************************************* */
        ImageIcon error404Icon = new ImageIcon("src/main/resources/error404_icon.png");
        if(error404Icon != null)
            frameAbout.setIconImage(error404Icon.getImage());


        frameAbout.getContentPane().add(label, BorderLayout.CENTER);

        // Display the window.
        frameAbout.pack();
        frameAbout.setVisible(true);
        frameAbout.setLocationRelativeTo(null);
    }
}
