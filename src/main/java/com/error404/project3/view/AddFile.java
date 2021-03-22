/*
Method to add a file to the index.
*/

package com.error404.project3.view;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddFile {

    // Components
    /* ***** */
    // JFileChooser
    static JFileChooser fileChooser = new JFileChooser(); // Create file chooser
    // FileNameExtensionFilter
    static FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt"); // Limit file types to
    // .txt
    /* ***** */

    static String fileName = null; // Variable to hold the file's name
    static long fileSize = 0; // Variable to hold the file's size
    static boolean isUTD = true; // Variable to hold the flag for up-to-date or not *** CURRENTLY HARDCODED TO TRUE ***

    public AddFile() throws IOException {

        // Set up fileChooser
        /* ***** */
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Set current directory to
        // user's home
        fileChooser.setFileFilter(filter); // Add filter to fileChooser
        /* ***** */

        // Show dialog and initialize return variable
        /* ***** */
        int isFileSelected = fileChooser.showOpenDialog(null); // isFileSelected is boolean flag for
        if (isFileSelected == JFileChooser.APPROVE_OPTION) {    // JFileChooser.APPROVE_OPTION
            File addFile = fileChooser.getSelectedFile();
            if (addFile.exists() && addFile.isFile() && addFile.canRead()) { // Test that the file exists, is a legal
                // file, and can be read by the program.

                try {
                    fileName = addFile.getCanonicalPath(); // Try to get the file's OS dependent, absolute path
                    fileSize = addFile.length(); // Try to get the file's size
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }

    public static String getFileName() {
        return fileName;
    }
    public static long getFileSize() {
        return (long) fileSize;
    }
    public static boolean getFileUTD() {
        return isUTD;
    }
}