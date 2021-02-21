package com.error404.project3.view;

import javax.swing.*;
import java.awt.*;

public class AboutGUI {
    static void aboutGui() { // About window

        // Create and set up the window.
        JFrame frameAbout = new JFrame("About");

        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(400, 400));

        label.setText(
                "<html>Developer names<br><br>Lauren Bartlett<p>SeanBrown<p>Briana McKenzie<br><br>Error404_Project3<br><br />https://github.com/DeltaWild/Error404_Project3.git"
                        + "<br /><br />I don't know HTML, obviously  </html>");

        frameAbout.getContentPane().add(label, BorderLayout.CENTER);

        // Display the window.
        frameAbout.pack();
        frameAbout.setVisible(true);
        frameAbout.setLocationRelativeTo(null);
    }
}
