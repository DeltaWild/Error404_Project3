package com.error404.project3.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class CustomRenderer extends DefaultTableCellRenderer {
    DefaultTableCellRenderer tCR = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component comp = tCR.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        SimpleDateFormat sDF = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a z");

        if (column == 1) {
            String modFileSize = value.toString() + " bytes";
            comp = tCR.getTableCellRendererComponent(table, modFileSize, isSelected, hasFocus, row, column);
        }

        if (column == 2) {
            Date modDate = new Date((Long) value);
            String modDateConverted = sDF.format(modDate);
            comp = tCR.getTableCellRendererComponent(table, modDateConverted, isSelected, hasFocus, row, column);
        }

        return comp;
    }
}