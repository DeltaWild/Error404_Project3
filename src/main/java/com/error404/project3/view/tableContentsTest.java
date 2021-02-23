/*
Holds dummy values for maintenance window display table
as well as override methods for AbstractTableModel.
*/

package com.error404.project3.view;

import javax.swing.table.AbstractTableModel;

class tableContentsTest extends AbstractTableModel {

    String[] columnNames = {
            "File Name",
            "File Size",
            "Up To Date"
    };
    Object[][] data = {
            {"File01.txt", "28kb", "Yes"},
            {"File02.txt", "99kb", "Yes"},
            {"File03.txt", "12kb", "No"}
    };

    @Override
    public int getRowCount() {
        return data.length;
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
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}