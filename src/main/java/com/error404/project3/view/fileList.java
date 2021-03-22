/*
Holds dummy values for maintenance window display table
as well as override methods for AbstractTableModel.
*/

package com.error404.project3.view;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class fileList extends AbstractTableModel {
    // Variables
    /* ***** */
    String[] columnNames = {  // Assign column names for table
            "File Name",
            "File Size",
            "Up To Date"
    };
    fileList listing = null; // Initialize fileList
    List<ListItem> itemList = new ArrayList(); // Create array to hold file information
    /* ***** */

    /* ***** */
    fileList() {
        listing = this;
    }

    public fileList getListing() {
        if (listing == null) {
            listing = new fileList();
        }
        return listing;
    }
    /* ***** */

    /* ***** */
    String getFileName(String fileName) { // Retrieve file name
        fileName = AddFile.getFileName();
        return fileName;
    }
    /* ***** */

    /* ***** */
    long getFileSize(long fileSize) { // Retrieve file size
        fileSize = AddFile.getFileSize();
        return fileSize;
    }
    /* ***** */

    /* ***** */
    boolean getFileUTD(boolean isUTD) { // Retrieve if file is up-to-date
        isUTD = AddFile.getFileUTD();
        return isUTD;
    }
    /* ***** */

    /* ***** */
    public int getFileCount() {
        int fileCount = itemList.size();
        return fileCount;
    }
    /* ***** */


    @Override
    public int getRowCount() {
        return itemList.size();
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
        ListItem fileDetails = (ListItem)itemList.get(row);
        switch (col) {
            case 0:
                return fileDetails.fileName;
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

   /* @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }*/
}