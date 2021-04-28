/*
File utilities methods, override methods for AbstractTableModel.
*/

package com.error404.project3.view;

import com.error404.project4.model.buildIndex;
import com.error404.project4.model.fileItem;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.Preferences;

public class fileList extends AbstractTableModel {

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
    Preferences pref = Preferences.userRoot(); // Get user root folder
    final static String PATH = "LAST_USED_DIRECTORY";
    String path = pref.get(PATH, ""); // Holds path of last file or empty string if not yet set
    /* ***** */

    // Constructor & table listener
    /* ***** */
    public fileList() {
        listing = this;

        this.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    try {
                        new buildIndex();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
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
    public static List<fileItem> fileInfo = new ArrayList<>(); // LIST OF FILES

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
                    fileChooser.setCurrentDirectory(new File(PATH));
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
                    pref.put(PATH, addFile.getCanonicalPath());
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
    /* ***** */

    public Long getFileID(String fileName) {
        Iterator iter1 = fileInfo.iterator();

        while(iter1.hasNext()) {
            fileItem file = (fileItem)iter1.next();
            if (file.fileName.equals(fileName)) {
                return file.fileID;
            }
        }
        return null;
    }

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