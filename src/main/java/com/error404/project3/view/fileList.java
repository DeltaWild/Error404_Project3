/*
File utilities methods, override methods for AbstractTableModel.
*/

package com.error404.project3.view;

import com.error404.project4.model.fileItem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class fileList extends AbstractTableModel {

    // Components
    /* ***** */
    // JFileChooser
    static JFileChooser fileChooser = new JFileChooser(); // Create file chooser
    // FileNameExtensionFilter
    static FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt"); // Limit file types to
    // .txt
    /* ***** */

    // Variables
    /* ***** */
    String[] columnNames = {  // Assign column names for table
            "File Name",
            "File Size",
            "Last Modified Date"
    };
    fileList listing; // Initialize fileList
    static long fileID; // *** May not need? ***
    static String fileName = null; // Variable to hold the file's name
    static long fileSize = 0; // Variable to hold the file's size
    static long fileModDate = 0; // Variable to hold file's last modified date
    /* ***** */

    // Constructor & utility methods
    /* ***** */
    fileList() {
        listing = this;
    }

    // Possible future usage...
    public fileList getListing() {
        if (listing == null) {
            listing = new fileList();
        }
        return listing;
    }

    // Search the table for matching file names. (Refuse duplicates)
    public boolean hasFile(String fileNameToCheck) {
        Iterator search = fileInfo.iterator();

        while (search.hasNext()) {
            fileItem fileItem = (fileItem)search.next();
            if (fileItem.fileName.equals(fileNameToCheck)) {
                return true;
            }
        }

        return false;
    }

    public int getFileCount() {
        return fileInfo.size();
    }
    /* ***** */


    // Add File Functionality
    /* ***** */
    public static List<fileItem> fileInfo = new ArrayList<>(); // Create array to hold file info

    public void AddFile() throws IOException {
        // Set up fileChooser
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Set current directory to
        // user's home
        fileChooser.setFileFilter(filter); // Add filter to fileChooser

        // Show dialog and initialize return variable
        int isFileSelected = fileChooser.showOpenDialog(null); // isFileSelected is boolean flag for
        if (isFileSelected == JFileChooser.APPROVE_OPTION) {    // JFileChooser.APPROVE_OPTION
            File addFile = fileChooser.getSelectedFile();
            if (addFile.exists() && addFile.isFile() && addFile.canRead()) { // Test that the file exists, is a legal
                // file, and can be read by the program.
                try {
                    fileID = (SearchGUI.idNumber++);
                    fileName = addFile.getCanonicalPath(); // Try to get the file's OS dependent, absolute path
                    fileSize = addFile.length(); // Try to get the file's size
                    fileModDate = addFile.lastModified(); // Try to get the file's last modified date
                    if (!hasFile(fileName)) { // Only add the file if it is not a duplicate
                        fileItem file = new fileItem(fileID, fileName, fileSize, fileModDate);
                        fileInfo.add(file);
                        this.fireTableDataChanged();
                        MaintenanceGUI.window.repaint();
                    }
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
    /* ***** */

    // Override methods for AbstractTableModel
    /* ***** */

    @Override
    public int getRowCount() {
        return fileInfo.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        fileItem fileDetails = fileInfo.get(row);
        switch (col) {
            case 0:
                return fileDetails.fileName;
            case 1:
                return fileDetails.fileSize;
            case 2:
                return fileDetails.fileModDate;
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

    /* ***** */
}