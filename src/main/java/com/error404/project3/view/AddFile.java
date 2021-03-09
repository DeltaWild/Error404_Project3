/*
Method to add a file to the index.
*/

package com.error404.project3.view;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddFile extends MaintenanceGUI {

    // Components
    /* ***** */
    // JFileChooser
    static JFileChooser fileChooser = new JFileChooser(); // Create file chooser
    // FileNameExtensionFilter
    static FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt"); // Limit file types to
    // .txt
    /* ***** */


    public AddFile() throws IOException {

        // Set up fileChooser
        /* ***** */
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Set current directory to
        // user's home
        fileChooser.setFileFilter(filter); // Add filter to fileChooser
        /* ***** */

        // Show dialog and initialize return variable
        /* ***** */
        int isFileSelected = fileChooser.showOpenDialog(frame); // isFileSelected is boolean flag for
        if (isFileSelected == JFileChooser.APPROVE_OPTION) {    // JFileChooser.APPROVE_OPTION
            File addFile = fileChooser.getSelectedFile();
            someMethod(addFile.getAbsolutePath()); // stubMethod for add file implementation
        }

    }
 // METHOD OPENS ADDITIONAL INSTANCES OF MAINTENANCEGUI, NEED TO FIX
    private void someMethod(String absolutePath) throws IOException {
        if (!absolutePath.isEmpty()) {
            JOptionPane.showMessageDialog(null, "This function is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
            //new AddFile();
        }
    }
}